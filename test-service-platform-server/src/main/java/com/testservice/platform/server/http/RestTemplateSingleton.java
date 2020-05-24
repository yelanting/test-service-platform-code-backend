/**
 * @author : 孙留平
 * @since : 2020年3月17日 下午6:15:53
 * @see:
 */
package com.testservice.platform.server.http;

import org.springframework.web.client.RestTemplate;

/**
 * @author : Administrator
 * @since : 2020年3月17日 下午6:15:53
 * @see : 一个静态的RestTemplate持有类
 */
public class RestTemplateSingleton {

	/**
	 * @see :
	 */
	private RestTemplateSingleton() {
	}

	private static class RestTemplateSingletonHolder {
		private static RestTemplate restTemplate = new RestTemplate();
	}

	public static RestTemplate getInstance() {
		return RestTemplateSingletonHolder.restTemplate;
	}

}
