/**
 * @author : 孙留平
 * @since : 2020年2月26日 下午8:07:29
 * @see:
 */
package com.testservice.platform.server.constant;

/**
 * @author : Administrator
 * @since : 2020年2月26日 下午8:07:29
 * @see :
 */
public class SysInitDataConstants {
	private SysInitDataConstants() {
	}

	/**
	 * 默认部门名称
	 */
	public static final String DEFAULT_DEPT_NAME = "默认部门";

	/**
	 * 默认用户名
	 */
	public static final String DEFAULT_ADMIN_USER = SysConstants.ADMIN;

	/**
	 * 默认加盐
	 */
	public static final String DEFAULT_SALT = "YzcmCZNvbXocrsz9dm8e";

	/**
	 * 默认角色名称
	 */

	public static final String DEFAULT_ROLE_NAME = "defaultRole";
	/**
	 * 默认角色描述
	 */
	public static final String DEFAULT_ROLE_REMARK = "默认角色";

	/**
	 * 全局参数初始化
	 * 
	 * @author : Administrator
	 * @since : 2020年3月19日 上午1:42:12
	 * @see :
	 */
	public static class GlobalParamInitConst {
		/**
		 * 禅道地址
		 */
		public static final String ZENTAO_URL_KEY = "zen_tao_url";

		/**
		 * 禅道登录用户
		 */
		public static final String ZENTAO_LOGIN_USERNAME_KEY = "zen_tao_login_username";

		/**
		 * 禅道登录密码
		 */
		public static final String ZENTAO_LOGIN_PASSWORD_KEY = "zen_tao_login_password";
	}

}
