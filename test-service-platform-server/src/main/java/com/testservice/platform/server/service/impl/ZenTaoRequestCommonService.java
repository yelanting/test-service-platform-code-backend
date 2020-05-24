/**
 * @author : 孙留平
 * @since : 2020年3月20日 上午8:01:14
 * @see:
 */
package com.testservice.platform.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.testservice.platform.server.zentao.ZenTaoHttpHelper;
import com.testservice.platform.server.zentao.util.ZenTaoUtil;
import com.testservice.platform.zentao.api.action.RequestAction;
import com.testservice.platform.zentao.api.entity.ZenTaoApiResponseObject;
import com.testservice.platform.util.exception.base.BusinessValidationException;

/**
 * @author : Administrator
 * @since : 2020年3月20日 上午8:01:14
 * @see :禅道通用请求
 */
@Service("zenTaoRequestCommonService")
public class ZenTaoRequestCommonService {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ZenTaoRequestCommonService.class);
    private ZenTaoHttpHelper zenTaoHttpHelper;

    public ZenTaoHttpHelper getZenTaoHttpHelper() {
        return zenTaoHttpHelper;
    }

    public void setZenTaoHttpHelper(ZenTaoHttpHelper zenTaoHttpHelper) {
        this.zenTaoHttpHelper = zenTaoHttpHelper;
    }

    public ZenTaoRequestCommonService() {
        super();
        this.zenTaoHttpHelper = new ZenTaoHttpHelper();
    }

    public ZenTaoRequestCommonService(ZenTaoHttpHelper zenTaoHttpHelper) {
        super();
        this.zenTaoHttpHelper = zenTaoHttpHelper;
    }

    /**
     * 根据id获取测试单详情
     * 
     * @see :
     * @param :
     * @return : ZenTaoApiResponseObject
     * @param id
     * @return
     */
    public ZenTaoApiResponseObject findZenTaoTestTaskById(Long id) {
        ResponseEntity<String> getTestTaskByIdResponse = this.zenTaoHttpHelper
                .get(String.format(
                        RequestAction.TestTaskAction.GET_TEST_TASK_DETAIL_ACTION,
                        id));

        if (null == getTestTaskByIdResponse) {
            throw new BusinessValidationException("获取禅道请求出错");
        }

        ZenTaoApiResponseObject zenTaoApiResponseObject = ZenTaoUtil
                .parseZenTaoApiResponseObjectFromResponseText(
                        getTestTaskByIdResponse.getBody());
        LOGGER.debug("查找到的测试单zenTaoApiResponseObject:{}",
                zenTaoApiResponseObject);
        return zenTaoApiResponseObject;
    }

    /**
     * 根据id获取测试单详情
     * 
     * @see :
     * @param :
     * @return : ZenTaoApiResponseObject
     * @param id
     * @return
     */
    public ZenTaoApiResponseObject findZenTaoTestCaseById(Long id) {
        ResponseEntity<String> getTestTaskByIdResponse = this.zenTaoHttpHelper
                .get(String.format(
                        RequestAction.TestCaseAction.GET_TESTCASE_DETAIL_ACTION,
                        id));

        if (null == getTestTaskByIdResponse) {
            throw new BusinessValidationException("获取禅道请求出错");
        }
        ZenTaoApiResponseObject zenTaoApiResponseObject = ZenTaoUtil
                .parseZenTaoApiResponseObjectFromResponseText(
                        getTestTaskByIdResponse.getBody());
        LOGGER.debug("查找到的测试用例的zenTaoApiResponseObject:{}",
                zenTaoApiResponseObject);
        return zenTaoApiResponseObject;
    }

    /**
     * 根据id获取测试单详情
     * 
     * @see :
     * @param :
     * @return : ZenTaoApiResponseObject
     * @param id
     * @return
     */
    public ZenTaoApiResponseObject findZenTaoTestCasesByTestTaskId(Long id) {
        ResponseEntity<String> getTestTaskByIdResponse = this.zenTaoHttpHelper
                .get(String.format(
                        RequestAction.TestCaseAction.GET_TESTCASK_CASES_ACTION,
                        id));

        if (null == getTestTaskByIdResponse) {
            throw new BusinessValidationException("获取禅道请求出错");
        }

        ZenTaoApiResponseObject zenTaoApiResponseObject = ZenTaoUtil
                .parseZenTaoApiResponseObjectFromResponseText(
                        getTestTaskByIdResponse.getBody());
        LOGGER.debug("查找到的测试用例的zenTaoApiResponseObject:{}",
                zenTaoApiResponseObject);
        return zenTaoApiResponseObject;
    }
}
