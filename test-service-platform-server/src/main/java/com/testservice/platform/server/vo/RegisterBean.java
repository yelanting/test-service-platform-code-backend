package com.testservice.platform.server.vo;

import java.util.Arrays;

import com.testservice.platform.server.model.SysUser;

/**
 * 登录接口封装对象
 * 
 * @author administrator
 * @date Oct 29, 2018
 */
public class RegisterBean extends SysUser {

	/**
	 * 确认密码
	 */
	private String confirmPassword;

	private Long[] roleIds;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "RegisterBean [confirmPassword=" + confirmPassword + ", roleIds="
		        + Arrays.toString(roleIds) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
		        + ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		RegisterBean other = (RegisterBean) obj;
		if (confirmPassword == null) {
			if (other.confirmPassword != null) {
				return false;
			}
		} else if (!confirmPassword.equals(other.confirmPassword)) {
			return false;
		}
		return true;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

}
