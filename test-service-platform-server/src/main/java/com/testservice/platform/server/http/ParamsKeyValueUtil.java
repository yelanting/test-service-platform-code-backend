/**
 * @author : 孙留平
 * @since : 2020年3月18日 下午5:32:50
 * @see:
 */
package com.testservice.platform.server.http;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author : Administrator
 * @since : 2020年3月18日 下午5:32:50
 * @see :
 */
public class ParamsKeyValueUtil {
	/**
	 * 把map转换成resttemplate支持的参数类型
	 * 
	 * @see :
	 * @param :
	 * @return : MultiValueMap
	 * @param map
	 * @return
	 */
	public static <T, V> MultiValueMap<T, V> changeMapToMultiValueMap(
	        Map<T, V> map) {
		Set<Entry<T, V>> entrySets = map.entrySet();
		MultiValueMap<T, V> multiValueMap = new LinkedMultiValueMap<>();

		for (Entry<T, V> entry : entrySets) {
			multiValueMap.add((T) entry.getKey(), (V) entry.getValue());
		}
		return multiValueMap;
	}
}
