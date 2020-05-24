/**
 * @author : 孙留平
 * @since : 2020年2月26日 上午10:41:34
 * @see:
 */
package com.testservice.platform.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testservice.platform.server.model.SysDept;
import com.testservice.platform.server.model.SysRole;
import com.testservice.platform.server.model.SysRoleDept;
import com.testservice.platform.server.model.SysUser;
import com.testservice.platform.server.model.SysUserRole;
import com.testservice.platform.server.service.SysDeptService;
import com.testservice.platform.server.service.SysRegisterService;
import com.testservice.platform.server.service.SysRoleDeptService;
import com.testservice.platform.server.service.SysRoleService;
import com.testservice.platform.server.service.SysUserRoleService;
import com.testservice.platform.server.service.SysUserService;
import com.testservice.platform.server.vo.RegisterBean;
import com.testservice.platform.util.exception.base.BusinessValidationException;

/**
 * @author : Administrator
 * @since : 2020年2月26日 上午10:41:34
 * @see :
 */

@Service("sysRegisterService")
public class SysRegisterServiceImpl implements SysRegisterService {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysUserRoleService sysUserRoleService;

	@Autowired
	private SysDeptService sysDeptService;

	@Autowired
	private SysRoleDeptService sysRoleDeptService;

	@Override
	public SysUser register(RegisterBean registerBean) {

		// 如果存在，就不能注册了
		if (null != sysUserService.findByName(registerBean.getName())) {
			throw new BusinessValidationException("帐号已经存在，不可再注册了");
		}

		validate(registerBean);

		Long[] roleIds = registerBean.getRoleIds();
		if (roleIds.length == 0) {
			throw new BusinessValidationException("必须选择至少一个角色");
		}

		// 处理默认部门
		SysDept defaultSysDept = sysDeptService.findDefaultDept();
		if (null != defaultSysDept) {
			registerBean.setDeptId(defaultSysDept.getId());
			registerBean.setDeptName(defaultSysDept.getName());
		}

		// 处理部门和角色
		List<SysRoleDept> sysRoleDepts = null;

		for (int i = 0; i < roleIds.length; i++) {
			sysRoleDepts = sysRoleDeptService
			        .findRoleDeptsByDeptId(defaultSysDept.getId());
			SysRoleDept sysRoleDept = new SysRoleDept();
			sysRoleDept.setRoleId(roleIds[i]);
			sysRoleDept.setDeptId(defaultSysDept.getId());

			if (!sysRoleDepts.contains(sysRoleDept)) {
				sysRoleDeptService.save(sysRoleDept);
			}
		}

		int saveUserResult = sysUserService.save(registerBean);
		if (saveUserResult <= 0) {
			throw new BusinessValidationException("注册用户失败");

		}

		Long insertedUserId = registerBean.getId();
		List<SysUserRole> sysUserRoles = new ArrayList<>();
		if (null != insertedUserId) {
			// 校验角色信息
			List<SysRole> sysRoles = new ArrayList<>();
			// 角色找到了，处理关系表
			for (int i = 0; i < roleIds.length; i++) {
				SysRole sysRole = sysRoleService.findById(roleIds[i]);

				if (null != sysRole) {
					sysRoles.add(sysRole);
					SysUserRole sysUserRole = new SysUserRole();
					sysUserRole.setRoleId(sysRole.getId());
					sysUserRole.setUserId(insertedUserId);
					sysUserRoleService.save(sysUserRole);
					sysUserRoles.add(sysUserRole);
				}
			}

			if (sysRoles.isEmpty()) {
				throw new BusinessValidationException("在你选择的角色中没有找到任何有效角色");
			}

			registerBean.setUserRoles(sysUserRoles);
		}

		return null;
	}

	private void validate(RegisterBean registerBean) {
		if (!registerBean.getPassword()
		        .equals(registerBean.getConfirmPassword())) {
			throw new BusinessValidationException("注册用户密码和确认密码不相同");
		}
	}

}
