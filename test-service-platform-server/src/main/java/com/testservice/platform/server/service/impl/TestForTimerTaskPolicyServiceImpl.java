/**
 * @author : 孙留平
 * @since : 2020年3月13日 上午1:55:49
 * @see:
 */
package com.testservice.platform.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.testservice.platform.server.service.TestForTimerTaskPolicyService;

/**
 * @author : Administrator
 * @since : 2020年3月13日 上午1:55:49
 * @see :
 */
@Service("testForTimerTaskPolicyService")
public class TestForTimerTaskPolicyServiceImpl
        implements TestForTimerTaskPolicyService {

	private static final Logger LOGGER = LoggerFactory
	        .getLogger(TestForTimerTaskPolicyServiceImpl.class);

	@Override
	public void testPolicy() {
		LOGGER.debug("这是一个测试方法，为了测试定时任务");
	}

}
