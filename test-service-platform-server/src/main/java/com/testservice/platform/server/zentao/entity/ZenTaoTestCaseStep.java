/**
 * @author : 孙留平
 * @since : 2020年3月18日 上午1:10:05
 * @see:
 */
package com.testservice.platform.server.zentao.entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author : Administrator
 * @since : 2020年3月18日 上午1:10:05
 * @see :
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZenTaoTestCaseStep {
	private Long id;
	private Long parent;

	@JSONField(name = "case")
	private Long caseId;
	private Long version;
	private String type;
	private String expect;
	private String desc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	public Long getCaseId() {
		return caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExpect() {
		return expect;
	}

	public void setExpect(String expect) {
		this.expect = expect;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "ZenTaoTestCaseStep [id=" + id + ", parent=" + parent
		        + ", caseId=" + caseId + ", version=" + version + ", type="
		        + type + ", expect=" + expect + ", desc=" + desc + "]";
	}

}
