/**
 * @author : 孙留平
 * @since : 2020年3月18日 上午1:24:55
 * @see:
 */
package com.testservice.platform.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.testservice.platform.server.dao.ZenTaoTestTaskModelMapper;
import com.testservice.platform.server.model.ZenTaoTestTaskModel;
import com.testservice.platform.server.page.MybatisPageHelper;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.page.PageResult;
import com.testservice.platform.server.page.Param;
import com.testservice.platform.server.service.ZenTaoTestTaskService;
import com.testservice.platform.server.util.SecurityUtils;
import com.testservice.platform.server.zentao.entity.ZenTaoTestTask;
import com.testservice.platform.server.zentao.util.ZenTaoUtil;
import com.testservice.platform.zentao.api.entity.ZenTaoApiResponseObject;
import com.testservice.platform.util.core.StringUtil;

/**
 * @author : Administrator
 * @since : 2020年3月18日 上午1:24:55
 * @see :
 */
@Service("zenTaoTestTaskService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ZenTaoTestTaskServiceImpl extends ZenTaoRequestBaseService
        implements ZenTaoTestTaskService {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ZenTaoTestTaskServiceImpl.class);

    @Autowired
    private ZenTaoTestTaskModelMapper zenTaoTestTaskModelMapper;

    @Override
    @HystrixCommand(fallbackMethod = "findZenTaoTestTaskByIdDefault")
    public ZenTaoTestTask findZenTaoTestTaskById(Long id) {
        LOGGER.debug("根据id查找测试单");
        if (null == id) {
            return null;
        }

        ZenTaoApiResponseObject zenTaoApiResponseObject = getZenTaoRequestCommonService()
                .findZenTaoTestTaskById(id);
        ZenTaoTestTask zenTaoTestTask = ZenTaoUtil
                .parseObjectFromZenTaoApiResponseObjectData(
                        zenTaoApiResponseObject, "task", ZenTaoTestTask.class);
        LOGGER.debug("查找到的测试单为:{}", zenTaoTestTask);
        return zenTaoTestTask;
    }

    public ZenTaoTestTask findZenTaoTestTaskByIdDefault(Long id) {
        LOGGER.debug("根据id查找测试单默认方法:{}", id);
        return null;
    }

    @Override
    public int save(ZenTaoTestTaskModel record) {
        if (null == record.getId() || record.getId() == 0) {
            return zenTaoTestTaskModelMapper.insert(record);
        }

        return zenTaoTestTaskModelMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(ZenTaoTestTaskModel record) {
        return zenTaoTestTaskModelMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<ZenTaoTestTaskModel> records) {

        for (ZenTaoTestTaskModel zenTaoTestTaskModel : records) {
            delete(zenTaoTestTaskModel);
        }

        return 0;
    }

    @Override
    public ZenTaoTestTaskModel findById(Long id) {
        ZenTaoTestTaskModel zenTaoTestTaskModel = zenTaoTestTaskModelMapper
                .selectByPrimaryKey(id);
        if (null != zenTaoTestTaskModel
                && null != zenTaoTestTaskModel.getZenTaoTestTaskId()) {
            zenTaoTestTaskModel.setZenTaoTestTask(findZenTaoTestTaskById(
                    zenTaoTestTaskModel.getZenTaoTestTaskId()));
        }

        return dealZenTaoTestTaskModel(zenTaoTestTaskModel);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Param label = pageRequest.getParam("label");
        Param filterByUsername = pageRequest.getParam("filterCurrentUser");

        PageResult pageResult;
        if (label != null) {
            pageResult = MybatisPageHelper.findPage(pageRequest,
                    zenTaoTestTaskModelMapper, "findPageByLabel",
                    label.getValue());
        } else if (null != filterByUsername
                && StringUtil.isStringAvaliable(filterByUsername.getValue())) {
            List<ZenTaoTestTaskModel> currentZenTaoTestTaskModels = filterCurrentUserTestTaskModel();
            // currentZenTaoTestTaskModels = dealZenTaoTestTaskModel(
            // currentZenTaoTestTaskModels);
            PageResult pageResult2 = new PageResult();
            pageResult2.setContent(currentZenTaoTestTaskModels);
            pageResult2.setPageNum(pageRequest.getPageNum());
            pageResult2.setPageSize(pageRequest.getPageSize());
            return pageResult2;

        } else {
            pageResult = MybatisPageHelper.findPage(pageRequest,
                    zenTaoTestTaskModelMapper);
        }
        List<ZenTaoTestTaskModel> zenTaoTestTaskModels = (List<ZenTaoTestTaskModel>) pageResult
                .getContent();

        zenTaoTestTaskModels = dealZenTaoTestTaskModel(zenTaoTestTaskModels);
        return pageResult;
    }

    @Override
    public List<ZenTaoTestTaskModel> findAll() {
        List<ZenTaoTestTaskModel> currentAll = zenTaoTestTaskModelMapper
                .findAll();
        return dealZenTaoTestTaskModel(currentAll);
    }

    @Override
    public ZenTaoTestTaskModel insertOrUpdate(ZenTaoTestTaskModel record) {
        save(record);
        return record;
    }

    @Override
    public List<ZenTaoTestTaskModel> findByLable(String label) {
        return dealZenTaoTestTaskModel(
                zenTaoTestTaskModelMapper.findByLable(label));
    }

    /**
     * 处理额外查询
     * 
     * @see :
     * @param :
     * @return : ZenTaoTestTaskModel
     * @param zenTaoTestTaskModel
     * @return
     */
    private ZenTaoTestTaskModel dealZenTaoTestTaskModel(
            ZenTaoTestTaskModel zenTaoTestTaskModel) {
        if (null == zenTaoTestTaskModel) {
            return null;
        }

        if (null == zenTaoTestTaskModel.getZenTaoTestTaskId()
                || 0 == zenTaoTestTaskModel.getZenTaoTestTaskId()) {

            return zenTaoTestTaskModel;
        }

        zenTaoTestTaskModel.setZenTaoTestTask(findZenTaoTestTaskById(
                zenTaoTestTaskModel.getZenTaoTestTaskId()));
        return zenTaoTestTaskModel;
    }

    /**
     * 处理额外查询
     * 
     * @see :
     * @param :
     * @return : ZenTaoTestTaskModel
     * @param zenTaoTestTaskModel
     * @return
     */
    private List<ZenTaoTestTaskModel> dealZenTaoTestTaskModel(
            List<ZenTaoTestTaskModel> zenTaoTestTaskModels) {
        if (null == zenTaoTestTaskModels || zenTaoTestTaskModels.isEmpty()) {
            return new ArrayList<ZenTaoTestTaskModel>();
        }

        for (ZenTaoTestTaskModel zenTaoTestTaskModel2 : zenTaoTestTaskModels) {
            zenTaoTestTaskModel2 = dealZenTaoTestTaskModel(
                    zenTaoTestTaskModel2);
        }
        return zenTaoTestTaskModels;
    }

    /**
     * 过滤当前帐号互
     * 
     * @return
     */
    private List<ZenTaoTestTaskModel> filterCurrentUserTestTaskModel() {
        return findAllByUsername(SecurityUtils.getUsername());
    }

    @Override
    public List<ZenTaoTestTaskModel> findAllByUsername(String username) {
        return dealZenTaoTestTaskModel(zenTaoTestTaskModelMapper
                .filterCurrentUserTestTaskModelsByUsername(username));
    }
}