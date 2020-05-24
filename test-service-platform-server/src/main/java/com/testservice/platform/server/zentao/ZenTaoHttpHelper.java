/**
 * @author : 孙留平
 * @since : 2020年3月17日 下午6:22:52
 * @see:
 */
package com.testservice.platform.server.zentao;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.testservice.platform.server.zentao.entity.ZenTaoServerInfo;

/**
 * @author : Administrator
 * @since : 2020年3月17日 下午6:22:52
 * @see :
 */
public class ZenTaoHttpHelper {
	private ZenTaoLoginHelper zenTaoLoginHelper;

	public ZenTaoHttpHelper(ZenTaoServerInfo zenTaoServerInfo) {
		super();
		this.zenTaoLoginHelper = new ZenTaoLoginHelper(zenTaoServerInfo);
	}

	/**
	 * @see :
	 */
	public ZenTaoHttpHelper() {
		this.zenTaoLoginHelper = new ZenTaoLoginHelper();
	}

	public ResponseEntity<String> post(String url, Map<String, String> params) {

		return this.zenTaoLoginHelper.postWithLogin(url, params);
	}

	public ResponseEntity<String> get(String url, Map<String, String> params) {

		return this.zenTaoLoginHelper.getWithLogin(url, params);
	}

	public ResponseEntity<String> get(String url) {
		return this.zenTaoLoginHelper.getWithLogin(url);
	}

	public ZenTaoLoginHelper getZenTaoLoginHelper() {
		return zenTaoLoginHelper;
	}

	public void setZenTaoLoginHelper(ZenTaoLoginHelper zenTaoLoginHelper) {
		this.zenTaoLoginHelper = zenTaoLoginHelper;
	}

	public static void main(String[] args) {
		ZenTaoHttpHelper zenTaoHttpHelper = new ZenTaoHttpHelper();
		zenTaoHttpHelper.get("testtask-cases-1.json");
		zenTaoHttpHelper.get("testtask-view-1.json");
	}
}
