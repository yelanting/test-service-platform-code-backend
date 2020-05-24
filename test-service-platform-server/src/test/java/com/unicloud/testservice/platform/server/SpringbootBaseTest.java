/**
 * @author : 孙留平
 * @since : 2020年3月6日 下午6:26:09
 * @see:
 */
package com.testservice.platform.server;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Administrator
 * @since : 2020年3月6日 下午6:26:09
 * @see :
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(locations = { "classpath:application.yml" })
@Transactional
public class SpringbootBaseTest {

	@Test
	void test() {
		System.out.println("这是一个测试");
	}

}
