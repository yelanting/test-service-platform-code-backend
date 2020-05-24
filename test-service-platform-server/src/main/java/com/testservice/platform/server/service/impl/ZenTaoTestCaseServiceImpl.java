/**
 * @author : 孙留平
 * @since : 2020年3月18日 上午1:25:44
 * @see:
 */
package com.testservice.platform.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.page.PageResult;
import com.testservice.platform.server.page.Param;
import com.testservice.platform.server.service.ZenTaoTestCaseService;
import com.testservice.platform.server.zentao.entity.ZenTaoResponseTestCasesUnderTask;
import com.testservice.platform.server.zentao.entity.ZenTaoTestCase;
import com.testservice.platform.server.zentao.util.ZenTaoUtil;
import com.testservice.platform.zentao.api.entity.ZenTaoApiResponseObject;
import com.testservice.platform.util.core.JsonUtil;
import com.testservice.platform.util.core.StringUtil;

/**
 * @author : Administrator
 * @since : 2020年3月18日 上午1:25:44
 * @see :
 */

@Service("zenTaoTestCaseService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ZenTaoTestCaseServiceImpl extends ZenTaoRequestBaseService
        implements ZenTaoTestCaseService {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ZenTaoTestCaseServiceImpl.class);

    @Override
    @HystrixCommand(fallbackMethod = "findZenTaoTestCaseByIdDefault")
    public ZenTaoTestCase findZenTaoTestCaseById(Long id) {
        ZenTaoApiResponseObject zenTaoApiResponseObject = getZenTaoRequestCommonService()
                .findZenTaoTestCaseById(id);
        ZenTaoTestCase zenTaoTestCase = ZenTaoUtil
                .parseObjectFromZenTaoApiResponseObjectData(
                        zenTaoApiResponseObject, "case", ZenTaoTestCase.class);
        LOGGER.debug("查找到的测试用例为:{}", zenTaoTestCase);
        return zenTaoTestCase;
    }

    @Override
    @HystrixCommand(fallbackMethod = "findZenTaoTestCasesByTestTaskIdDefault")
    public List<ZenTaoTestCase> findZenTaoTestCasesByTestTaskId(
            Long testTaskId) {
        ZenTaoApiResponseObject zenTaoApiResponseObject = getZenTaoRequestCommonService()
                .findZenTaoTestCasesByTestTaskId(testTaskId);

        ZenTaoResponseTestCasesUnderTask zenTaoResponseTestCasesUnderTask = JsonUtil
                .jsonToObject(zenTaoApiResponseObject.getData(),
                        ZenTaoResponseTestCasesUnderTask.class);

        if (null == zenTaoResponseTestCasesUnderTask) {
            return new ArrayList<>();

        }

        LOGGER.debug("zenTaoResponseTestCasesUnderTask:{}",
                zenTaoResponseTestCasesUnderTask);
        Map<Long, ZenTaoTestCase> zenTaoTestCases = ZenTaoUtil
                .parseObjectFromZenTaoApiResponseObjectData(
                        zenTaoApiResponseObject, "runs", HashMap.class);

        if (null == zenTaoTestCases) {
            return new ArrayList<>();
        }

        LOGGER.debug("runs为:{}", zenTaoTestCases);
        List<ZenTaoTestCase> results = new ArrayList<>();
        results.addAll(zenTaoTestCases.values());
        // for (ZenTaoTestCase eachEntry : zenTaoTestTasks.values()) {
        // LOGGER.debug("eachEntry:{}", eachEntry);
        // results.add(JsonUtil.jsonToObject(eachEntry.toString(),
        // ZenTaoTestCase.class));
        // }

        // results.sort(new Comparator<ZenTaoTestCase>() {
        // @Override
        // public int compare(ZenTaoTestCase o1, ZenTaoTestCase o2) {
        // return (int) (o1.getCaseId() - o2.getCaseId());
        // }
        // });
        LOGGER.debug("results为:{}", results);
        return results;
    }

    public List<ZenTaoTestCase> findZenTaoTestCasesByTestTaskIdDefault(
            Long id) {
        LOGGER.debug(
                "获取测试用例单下的测试用例信息的默认回调findZenTaoTestCasesByTestTaskIdDefault:{}",
                id);
        return new ArrayList<ZenTaoTestCase>();
    }

    public ZenTaoTestCase findZenTaoTestCaseByIdDefault(Long id) {
        LOGGER.debug("或者测试用例信息的默认回调findZenTaoTestCaseByIdDefault:{}", id);
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return new PageResult();
    }

    @Override
    public PageResult findPageByTestTaskId(PageRequest pageRequest) {
        Param label = pageRequest.getParam("testTaskId");
        if (null == label || StringUtil.isEmpty(label.getValue())) {
            return new PageResult();
        }

        Long testTaskId = Long.parseLong(label.getValue());
        List<ZenTaoTestCase> testCaseList = findZenTaoTestCasesByTestTaskId(
                testTaskId);

        PageResult pageResult = new PageResult();
        pageResult.setContent(testCaseList);
        pageResult.setTotalSize(testCaseList.size());
        return pageResult;
    }
}
