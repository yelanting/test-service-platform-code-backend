/**
 * @author : 孙留平
 * @since : 2020年3月18日 上午1:09:10
 * @see:
 */
package com.testservice.platform.server.service;

import java.util.List;

import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.page.PageResult;
import com.testservice.platform.server.zentao.entity.ZenTaoTestCase;

/**
 * @author : Administrator
 * @since : 2020年3月18日 上午1:09:10
 * @see :
 */
public interface ZenTaoTestCaseService {
	/**
	 * 获取测试单信息
	 */
	ZenTaoTestCase findZenTaoTestCaseById(Long id);

	/**
	 * 根据测试单id获取测试用例
	 * 
	 * @see :
	 * @param :
	 * @return : List<ZenTaoTestCase>
	 * @param testTaskId
	 * @return
	 */
	List<ZenTaoTestCase> findZenTaoTestCasesByTestTaskId(Long testTaskId);

	/**
	 * 获取分页
	 * 
	 * @see :
	 * @param :
	 * @return : List<ZenTaoTestCase>
	 * @param testTaskId
	 * @return
	 */
	PageResult findPage(PageRequest pageRequest);

	/**
	 * 获取分页
	 * 
	 * @see :
	 * @param :
	 * @return : List<ZenTaoTestCase>
	 * @param testTaskId
	 * @return
	 */
	PageResult findPageByTestTaskId(PageRequest pageRequest);
}
