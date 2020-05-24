/**
 * @author : 孙留平
 * @since : 2020年2月27日 下午3:05:49
 * @see:
 */
package com.testservice.platform.server.model;

/**
 * @author : Administrator
 * @since : 2020年2月27日 下午3:05:49
 * @see :集成平台实体
 */
public class Platform extends BaseModel {

	/**
	 * 名称
	 */
	private String platformName;

	/**
	 * 访问地址
	 */
	private String accessUrl;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;
	/**
	 * 删除标记
	 */
	private Boolean delFlag;

	/**
	 * 图片地址
	 */
	private String imageUrl;

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public String getAccessUrl() {
		return accessUrl;
	}

	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Platform [platformName=" + platformName + ", accessUrl="
		        + accessUrl + ", username=" + username + ", password="
		        + password + ", delFlag=" + delFlag + ", imageUrl=" + imageUrl
		        + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
		        + ((accessUrl == null) ? 0 : accessUrl.hashCode());
		result = prime * result + ((delFlag == null) ? 0 : delFlag.hashCode());
		result = prime * result
		        + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result
		        + ((password == null) ? 0 : password.hashCode());
		result = prime * result
		        + ((platformName == null) ? 0 : platformName.hashCode());
		result = prime * result
		        + ((username == null) ? 0 : username.hashCode());
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
		Platform other = (Platform) obj;
		if (accessUrl == null) {
			if (other.accessUrl != null) {
				return false;
			}
		} else if (!accessUrl.equals(other.accessUrl)) {
			return false;
		}
		if (delFlag == null) {
			if (other.delFlag != null) {
				return false;
			}
		} else if (!delFlag.equals(other.delFlag)) {
			return false;
		}
		if (imageUrl == null) {
			if (other.imageUrl != null) {
				return false;
			}
		} else if (!imageUrl.equals(other.imageUrl)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (platformName == null) {
			if (other.platformName != null) {
				return false;
			}
		} else if (!platformName.equals(other.platformName)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
