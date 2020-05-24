package com.testservice.platform.server.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testservice.platform.server.constant.SysConstants;
import com.testservice.platform.server.dao.SysRoleMapper;
import com.testservice.platform.server.dao.SysUserMapper;
import com.testservice.platform.server.dao.SysUserRoleMapper;
import com.testservice.platform.server.model.SysMenu;
import com.testservice.platform.server.model.SysRole;
import com.testservice.platform.server.model.SysUser;
import com.testservice.platform.server.model.SysUserRole;
import com.testservice.platform.server.page.MybatisPageHelper;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.page.PageResult;
import com.testservice.platform.server.page.Param;
import com.testservice.platform.server.service.SysMenuService;
import com.testservice.platform.server.service.SysUserRoleService;
import com.testservice.platform.server.service.SysUserService;
import com.testservice.platform.server.util.PasswordUtils;
import com.testservice.platform.util.constant.GlobalExceptionMessage;
import com.testservice.platform.util.core.DateTimeUtils;
import com.testservice.platform.util.core.PoiUtils;
import com.testservice.platform.util.exception.base.BusinessValidationException;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Transactional
    @Override
    public int save(SysUser record) {
        /**
         * 加盐方式，新增则用新盐，修改则用旧盐
         */
        String salt = null;
        String password = null;

        if (null == record.getId() || record.getId() == 0) {
            // 新增用户
            if (findByName(record.getName()) != null) {
                throw new BusinessValidationException("用户名已存在!");
            }

            salt = PasswordUtils.getSalt();
            password = PasswordUtils.encode(record.getPassword(), salt);
            record.setSalt(salt);
            record.setPassword(password);
            // 新增用户
            sysUserMapper.insert(record);
        } else {
            /**
             * 修改
             */
            SysUser user = findById(record.getId());
            if (user != null) {
                if (SysConstants.ADMIN.equalsIgnoreCase(user.getName())) {
                    throw new BusinessValidationException("超级管理员不允许修改!");
                }
            }

            if (null == user) {
                throw new BusinessValidationException("未查找到该用户，无法修改！");
            }

            salt = user.getSalt();
            String newPassword = PasswordUtils.encode(record.getPassword(),
                    salt);
            record.setSalt(salt);
            record.setPassword(newPassword);
            // 更新用户信息
            sysUserMapper.updateByPrimaryKey(record);
        }

        SysUser newUser = findByName(record.getName());
        if (null == newUser) {
            throw new BusinessValidationException("增加或者修改完用户之后，没有找到这个用户");
        }

        Long id = newUser.getId();
        // 更新用户角色
        if (id != null && id == 0) {
            return 1;
        }

        if (id != null) {
            for (SysUserRole sysUserRole : record.getUserRoles()) {
                sysUserRole.setUserId(id);
            }
        } else {
            sysUserRoleMapper.deleteByUserId(record.getId());
        }
        for (SysUserRole sysUserRole : record.getUserRoles()) {
            sysUserRoleMapper.insert(sysUserRole);
        }
        return 1;
    }

    @Override
    public int delete(SysUser record) {
        if (null == record || null == record.getId()) {
            throw new BusinessValidationException(
                    GlobalExceptionMessage.NULL_PARAMETER_MESSAGE);
        }

        SysUser currentSysUser = findById(record.getId());

        if (null == currentSysUser) {
            throw new BusinessValidationException("该记录不存在，无法删除");
        }

        // 删除用户
        sysUserMapper.deleteByPrimaryKey(record.getId());
        // 删除该用户关联的用户角色表
        sysUserRoleService.deleteByUserId(record.getId());
        return 1;

    }

    @Override
    public int delete(List<SysUser> records) {
        for (SysUser record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysUser findById(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysUser findByName(String name) {
        return sysUserMapper.findByName(name);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        PageResult pageResult = null;
        Param name = pageRequest.getParam("name");
        Param email = pageRequest.getParam("email");
        if (name != null) {
            if (email != null) {
                pageResult = MybatisPageHelper.findPage(pageRequest,
                        sysUserMapper, "findPageByNameAndEmail",
                        name.getValue(), email.getValue());
            } else {
                pageResult = MybatisPageHelper.findPage(pageRequest,
                        sysUserMapper, "findPageByName", name.getValue());
            }
        } else {
            pageResult = MybatisPageHelper.findPage(pageRequest, sysUserMapper);
        }
        // 加载用户角色信息
        findUserRoles(pageResult);
        return pageResult;
    }

    /**
     * 加载用户角色
     * 
     * @param pageResult
     */
    private void findUserRoles(PageResult pageResult) {
        List<?> content = pageResult.getContent();
        for (Object object : content) {
            SysUser sysUser = (SysUser) object;
            List<SysUserRole> userRoles = findUserRoles(sysUser.getId());
            sysUser.setUserRoles(userRoles);
            sysUser.setRoleNames(getRoleNames(userRoles));
        }
    }

    private String getRoleNames(List<SysUserRole> userRoles) {
        StringBuilder sb = new StringBuilder();
        for (Iterator<SysUserRole> iter = userRoles.iterator(); iter
                .hasNext();) {
            SysUserRole userRole = iter.next();
            SysRole sysRole = sysRoleMapper
                    .selectByPrimaryKey(userRole.getRoleId());
            if (sysRole == null) {
                continue;
            }
            sb.append(sysRole.getRemark());
            if (iter.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @Override
    public Set<String> findPermissions(String userName) {
        Set<String> perms = new HashSet<>();
        List<SysMenu> sysMenus = sysMenuService.findByUser(userName);
        for (SysMenu sysMenu : sysMenus) {
            if (sysMenu.getPerms() != null && !"".equals(sysMenu.getPerms())) {
                perms.add(sysMenu.getPerms());
            }
        }
        return perms;
    }

    @Override
    public List<SysUserRole> findUserRoles(Long userId) {
        return sysUserRoleMapper.findUserRoles(userId);
    }

    @Override
    public File createUserExcelFile(PageRequest pageRequest) {
        PageResult pageResult = findPage(pageRequest);
        return createUserExcelFile(pageResult.getContent());
    }

    public static File createUserExcelFile(List<?> records) {
        if (records == null) {
            records = new ArrayList<>();
        }
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row0 = sheet.createRow(0);
        int columnIndex = 0;
        row0.createCell(columnIndex).setCellValue("No");
        row0.createCell(++columnIndex).setCellValue("ID");
        row0.createCell(++columnIndex).setCellValue("用户名");
        row0.createCell(++columnIndex).setCellValue("昵称");
        row0.createCell(++columnIndex).setCellValue("机构");
        row0.createCell(++columnIndex).setCellValue("角色");
        row0.createCell(++columnIndex).setCellValue("邮箱");
        row0.createCell(++columnIndex).setCellValue("手机号");
        row0.createCell(++columnIndex).setCellValue("状态");
        row0.createCell(++columnIndex).setCellValue("头像");
        row0.createCell(++columnIndex).setCellValue("创建人");
        row0.createCell(++columnIndex).setCellValue("创建时间");
        row0.createCell(++columnIndex).setCellValue("最后更新人");
        row0.createCell(++columnIndex).setCellValue("最后更新时间");
        for (int i = 0; i < records.size(); i++) {
            SysUser user = (SysUser) records.get(i);
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < columnIndex + 1; j++) {
                row.createCell(j);
            }
            columnIndex = 0;
            row.getCell(columnIndex).setCellValue(i + 1);
            row.getCell(++columnIndex).setCellValue(user.getId());
            row.getCell(++columnIndex).setCellValue(user.getName());
            row.getCell(++columnIndex).setCellValue(user.getNickName());
            row.getCell(++columnIndex).setCellValue(user.getDeptName());
            row.getCell(++columnIndex).setCellValue(user.getRoleNames());
            row.getCell(++columnIndex).setCellValue(user.getEmail());
            row.getCell(++columnIndex).setCellValue(user.getStatus());
            row.getCell(++columnIndex).setCellValue(user.getAvatar());
            row.getCell(++columnIndex).setCellValue(user.getCreateBy());
            row.getCell(++columnIndex).setCellValue(
                    DateTimeUtils.getDateTime(user.getCreateTime()));
            row.getCell(++columnIndex).setCellValue(user.getLastUpdateBy());
            row.getCell(++columnIndex).setCellValue(
                    DateTimeUtils.getDateTime(user.getLastUpdateTime()));
        }
        return PoiUtils.createExcelFile(workbook, "download_user");
    }

}
