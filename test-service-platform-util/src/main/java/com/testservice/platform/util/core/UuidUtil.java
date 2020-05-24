/**
 * Project Name: commons-util
 * File Name: UuidUtil.java
 * Date: 2019年9月25日 上午11:34:44
 * Copyright (c) 2019, qing121171@gmail.com All Rights Reserved.
 */
package com.testservice.platform.util.core;

import java.util.UUID;

/**
 * @author : 孙留平
 * @since : 2019年9月25日 上午11:34:44
 * @see :
 *      随机产生UUID
 */
public class UuidUtil {
	private UuidUtil() {

	}

	public static UUID generateId() {
		return UUID.randomUUID();
	}
}
