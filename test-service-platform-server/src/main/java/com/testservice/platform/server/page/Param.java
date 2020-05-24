package com.testservice.platform.server.page;

/**
 * 分页参数
 * 
 * @author Administrator
 * @date Jan 19, 2019
 */
public class Param {
	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Param [name=" + name + ", value=" + value + "]";
	}
}