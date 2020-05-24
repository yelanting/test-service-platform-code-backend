/**
 * @author : 孙留平
 * @since : 2020年3月18日 上午1:10:19
 * @see:
 */
package com.testservice.platform.server.zentao.entity;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author : Administrator
 * @since : 2020年3月18日 上午1:10:19
 * @see :禅道测试单
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZenTaoTestTask {
	private String name;
	private String productID;
	private ZenTaoTestVersion task;
	private Map<Long, ZenTaoTestCase> runs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public ZenTaoTestVersion getTask() {
		return task;
	}

	public void setTask(ZenTaoTestVersion task) {
		this.task = task;
	}

	public Map<Long, ZenTaoTestCase> getRuns() {
		return runs;
	}

	public void setRuns(Map<Long, ZenTaoTestCase> runs) {
		this.runs = runs;
	}

	@Override
	public String toString() {
		return "ZenTaoTestTask [name=" + name + ", productID=" + productID
		        + ", task=" + task + ", runs=" + runs + "]";
	}
}
