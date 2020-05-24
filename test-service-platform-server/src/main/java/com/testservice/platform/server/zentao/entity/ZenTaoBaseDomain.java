/**
 * @author : 孙留平
 * @since : 2020年3月20日 上午11:34:35
 * @see:
 */
package com.testservice.platform.server.zentao.entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author : Administrator
 * @since : 2020年3月20日 上午11:34:35
 * @see :
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ZenTaoBaseDomain {
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "ZenTaoBaseDomain [title=" + title + "]";
	}
}
