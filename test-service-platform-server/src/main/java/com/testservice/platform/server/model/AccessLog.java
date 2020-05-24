/**
 * @author : 孙留平
 * @since : 2020年3月12日 上午9:48:39
 * @see:
 */
package com.testservice.platform.server.model;

/**
 * @author : Administrator
 * @since : 2020年3月12日 上午9:48:39
 * @see : 记录访问日志
 */
public class AccessLog extends SysLog {
	/**
	 */
	private static final long serialVersionUID = 1207556438143611079L;
	/**
	 * 访问url
	 */
	private String accessUrl;

	public String getAccessUrl() {
		return accessUrl;
	}

	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}

	@Override
	public String toString() {
		return "AccessLog [accessUrl=" + accessUrl + ", getUserName()="
		        + getUserName() + ", getOperation()=" + getOperation()
		        + ", getMethod()=" + getMethod() + ", getParams()="
		        + getParams() + ", getTime()=" + getTime() + ", getIp()="
		        + getIp() + ", toString()=" + super.toString() + ", getId()="
		        + getId() + ", getCreateBy()=" + getCreateBy()
		        + ", getCreateTime()=" + getCreateTime()
		        + ", getLastUpdateBy()=" + getLastUpdateBy()
		        + ", getLastUpdateTime()=" + getLastUpdateTime()
		        + ", getDescription()=" + getDescription() + ", getRemarks()="
		        + getRemarks() + ", getClass()=" + getClass() + ", hashCode()="
		        + hashCode() + "]";
	}
}
