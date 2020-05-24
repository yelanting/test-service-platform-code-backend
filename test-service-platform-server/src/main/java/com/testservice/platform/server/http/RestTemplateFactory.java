/**
 * @author : 孙留平
 * @since : 2020年3月17日 下午6:15:53
 * @see:
 */
package com.testservice.platform.server.http;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author : Administrator
 * @since : 2020年3月17日 下午6:15:53
 * @see : 一个静态的RestTemplate持有类
 */
public class RestTemplateFactory {

	/**
	 * @see :
	 */
	private RestTemplateFactory() {
	}

	private static class RestTemplateSingletonHolder {
		private static RestTemplate restTemplate = new RestTemplate();
	}

	public static RestTemplate getRestTemplate() {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(10 * 1000);
		requestFactory.setReadTimeout(10 * 1000);
		RestTemplateSingletonHolder.restTemplate
		        .setRequestFactory(requestFactory);
		return RestTemplateSingletonHolder.restTemplate;
	}

}
