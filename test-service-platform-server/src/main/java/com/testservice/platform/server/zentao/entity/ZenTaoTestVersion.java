/**
 * @author : 孙留平
 * @since : 2020年3月18日 下午10:19:09
 * @see:
 */
package com.testservice.platform.server.zentao.entity;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.testservice.platform.server.json.CustomJsonDateDeserializer;

/**
 * @author : Administrator
 * @since : 2020年3月18日 下午10:19:09
 * @see :版本
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZenTaoTestVersion {
	private String id;
	private String name;
	private Long product;
	private Long project;
	private Long build;
	private String owner;
	private String pri;

	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private Date begin;

	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private Date end;
	private String mailto;
	private String desc;
	private String report;
	private String status;
	private String subStatus;
	private Long deleted;
	private String productName;
	private String productType;
	private String projectName;
	private String buildName;
	private Long branch;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

	public Long getProject() {
		return project;
	}

	public void setProject(Long project) {
		this.project = project;
	}

	public Long getBuild() {
		return build;
	}

	public void setBuild(Long build) {
		this.build = build;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPri() {
		return pri;
	}

	public void setPri(String pri) {
		this.pri = pri;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getMailto() {
		return mailto;
	}

	public void setMailto(String mailto) {
		this.mailto = mailto;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}

	public Long getDeleted() {
		return deleted;
	}

	public void setDeleted(Long deleted) {
		this.deleted = deleted;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public Long getBranch() {
		return branch;
	}

	public void setBranch(Long branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "ZenTaoTestVersion [id=" + id + ", name=" + name + ", product="
		        + product + ", project=" + project + ", build=" + build
		        + ", owner=" + owner + ", pri=" + pri + ", begin=" + begin
		        + ", end=" + end + ", mailto=" + mailto + ", desc=" + desc
		        + ", report=" + report + ", status=" + status + ", subStatus="
		        + subStatus + ", deleted=" + deleted + ", productName="
		        + productName + ", productType=" + productType
		        + ", projectName=" + projectName + ", buildName=" + buildName
		        + ", branch=" + branch + "]";
	}
}
