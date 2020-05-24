package com.testservice.platform.server.service;

import java.io.File;
import java.util.List;
import java.util.Set;

import com.testservice.platform.server.model.SysUser;
import com.testservice.platform.server.model.SysUserRole;
import com.testservice.platform.server.page.PageRequest;

/**
 * 用户管理
 * @author administrator
 * @date Jan 13, 2019
 */
public interface SysUserService extends CurdService<SysUser> {

	SysUser findByName(String username);

	/**
	 * 查找用户的菜单权限标识集合
	 * @param userName
	 * @return
	 */
	Set<String> findPermissions(String userName);

	/**
	 * 查找用户的角色集合
	 * @param userName
	 * @return
	 */
	List<SysUserRole> findUserRoles(Long userId);

	/**
	 * 生成用户信息Excel文件
	 * @param pageRequest 要导出的分页查询参数
	 * @return
	 */
	File createUserExcelFile(PageRequest pageRequest);

}
