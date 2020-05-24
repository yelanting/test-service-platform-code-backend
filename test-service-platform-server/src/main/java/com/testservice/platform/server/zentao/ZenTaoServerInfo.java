/**
 * @author : 孙留平
 * @since : 2020年3月17日 下午6:23:16
 * @see:
 */
package com.testservice.platform.server.zentao;

import com.testservice.platform.zentao.api.define.ConstDefine;

/**
 * @author : Administrator
 * @since : 2020年3月17日 下午6:23:16
 * @see : 禅道的服务器信息
 */
public class ZenTaoServerInfo {
	/**
	 * 禅道的服务器url
	 */
	private String zenTaoServerUrl;
	private String zenTaoHost;
	private int zenTaoPort;
	private String loginUsername;
	private String loginPassword;

	public static class Builder {
		/**
		 * 只能指定一次
		 */
		private String zenTaoServerUrl = ConstDefine.DEFAULT_ZENTAO_URL;
		private String loginUsername = ConstDefine.DEFAULT_LOGIN_ROOT_USER;
		private String loginPassword = ConstDefine.DEFAULT_LOGIN_ROOT_PASSWORD;

		public Builder(String loginUsername, String loginPassword) {
			this.loginUsername = loginUsername;
			this.loginPassword = loginPassword;
		}

		public Builder() {
			this.loginUsername = ConstDefine.DEFAULT_LOGIN_ROOT_USER;
			this.loginPassword = ConstDefine.DEFAULT_LOGIN_ROOT_PASSWORD;
		}

		public Builder loginUsername(String loginUsername) {
			this.loginUsername = loginUsername;
			return this;
		}

		public Builder loginPassword(String loginPassword) {
			this.loginPassword = loginPassword;
			return this;
		}

		public Builder zenTaoServerUrl(String zenTaoServerUrl) {
			this.zenTaoServerUrl = zenTaoServerUrl;
			return this;
		}

		public ZenTaoServerInfo build() {
			return new ZenTaoServerInfo(this);
		}
	}

	private ZenTaoServerInfo(Builder builder) {
		this.loginUsername = builder.loginUsername;
		this.loginPassword = builder.loginPassword;
		this.zenTaoServerUrl = builder.zenTaoServerUrl;
	}

	public String getZenTaoServerUrl() {
		return zenTaoServerUrl;
	}

	public String getZenTaoHost() {
		return zenTaoHost;
	}

	public int getZenTaoPort() {
		return zenTaoPort;
	}

	public String getLoginUsername() {
		return loginUsername;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	@Override
	public String toString() {
		return "ZenTaoServerUrlInfo [zenTaoServerUrl=" + zenTaoServerUrl
		        + ", zenTaoHost=" + zenTaoHost + ", zenTaoPort=" + zenTaoPort
		        + ", loginUsername=" + loginUsername + ", loginPassword="
		        + loginPassword + "]";
	}
}
