/**
 * @author : 孙留平
 * @since : 2020年3月18日 下午5:13:41
 * @see:
 */
package com.testservice.platform.zentao.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author : Administrator
 * @since : 2020年3月18日 下午5:13:41
 * @see :
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZenTaoApiResponseObject {
	private String status = "success";
	private Object data;
	private String md5;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	@Override
	public String toString() {
		return "ZenTaoApiResponse [status=" + status + ", data=" + data
		        + ", md5=" + md5 + "]";
	}
}
