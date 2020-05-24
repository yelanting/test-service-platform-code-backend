/**
 * @author : 孙留平
 * @since : 2020年2月18日 下午3:47:30
 * @see:
 */
package com.testservice.platform.server.model;

/**
 * @author : Administrator
 * @since : 2020年2月18日 下午3:47:30
 * @see :
 */
public class Apk extends BaseModel {
	private String appName;
	/**
	 * 包名
	 */
	private String packageName;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 标记
	 */

	private String remarks;

	private boolean delFlag;

	/**
	 * @see :
	 */
	public Apk() {
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Apk [appName=" + appName + ", packageName=" + packageName
		        + ", description=" + description + ", remarks=" + remarks
		        + ", delFlag=" + delFlag + "]";
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}

}
