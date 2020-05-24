package com.testservice.platform.server.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础模型
 * 
 * @author administrator
 * @date 2020年2月27日 15:14:39
 */
public class BaseModel implements Serializable {

	private Long id;

	private String createBy;

	private Date createTime;

	private String lastUpdateBy;

	private Date lastUpdateTime;
	/**
	 * 描述
	 */
	private String description;

	/**
	 * 备注
	 */
	private String remarks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "BaseModel [id=" + id + ", createBy=" + createBy
		        + ", createTime=" + createTime + ", lastUpdateBy="
		        + lastUpdateBy + ", lastUpdateTime=" + lastUpdateTime
		        + ", description=" + description + ", remarks=" + remarks + "]";
	}

}
