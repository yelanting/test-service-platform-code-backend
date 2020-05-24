/**
 * @author : 孙留平
 * @since : 2019年5月7日 下午7:15:13
 * @see:
 */
package com.testservice.platform.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testservice.platform.server.dao.GlobalParamMapper;
import com.testservice.platform.server.global.GlobalAuth;
import com.testservice.platform.server.model.GlobalParam;
import com.testservice.platform.server.page.MybatisPageHelper;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.page.PageResult;
import com.testservice.platform.server.page.Param;
import com.testservice.platform.server.service.GlobalParamService;
import com.testservice.platform.server.util.SecurityUtils;
import com.testservice.platform.util.core.StringUtil;
import com.testservice.platform.util.core.ValidationUtil;
import com.testservice.platform.util.exception.base.BusinessValidationException;

/**
 * @author : Administrator
 * @since : 2019年5月7日 下午7:15:13
 * @see :
 */
@Service("globalParamService")
public class GlobalParamServiceImpl implements GlobalParamService {

    private static final Logger logger = LoggerFactory
            .getLogger(GlobalParamServiceImpl.class);

    @Autowired
    private GlobalParamMapper globalParamMapper;

    /**
     * @see 获取列表
     */
    @Override
    public List<GlobalParam> getList() {
        return globalParamMapper.findAll();
    }

    /**
     * @see 添加全局参数
     */
    @Override
    public GlobalParam addGlobalParam(GlobalParam globalParam) {
        logger.info("添加全局参数:{}", globalParam);
        if (checkParamKeyExists(globalParam.getParamKey())) {
            throw new BusinessValidationException("该key已经存在，不可重复添加");
        }

        try {

            int resultKey = globalParamMapper.insert(globalParam);
            globalParam.setId(Long.valueOf(resultKey));
            return globalParam;
        } catch (Exception e) {
            logger.error("添加全局参数失败,错误信息:{}", e.getMessage());
            throw new BusinessValidationException("添加全局参数失败");
        }
    }

    /**
     * @see com.tianque.yunxiao.connect.server.service.GlobalParamService#updateGlobalParam(com.tianque.yunxiao.connect.server.model.GlobalParam)
     */
    @Override
    public GlobalParam updateGlobalParam(GlobalParam globalParam) {
        logger.info("修改全局参数");
        ValidationUtil.validateNull(globalParam.getId(), null);

        if (checkParamKeyExists(globalParam)) {
            throw new BusinessValidationException("该key已经存在，不可修改为此key");
        }

        GlobalParam currentGlobalParam = selectByObject(globalParam);

        if (null == currentGlobalParam) {
            throw new BusinessValidationException("待修改对象不存在，不能修改");
        }

        try {
            this.globalParamMapper.updateByPrimaryKey(globalParam);
            return globalParam;
        } catch (Exception e) {
            throw new BusinessValidationException("修改失败");
        }

    }

    /**
     * @see com.tianque.yunxiao.connect.server.service.GlobalParamService#searchGlobalParamsBySearchContent(java.lang.String)
     */
    @Override
    public List<GlobalParam> searchGlobalParamsBySearchContent(
            String searchContent) {
        return globalParamMapper.findGlobalParamsByParamKeyLike(searchContent);
    }

    /**
     * @see 单个删除
     */
    @Override
    public Long deleteGlobalParam(Long id) {
        ValidationUtil.validateNull(id, null);
        globalParamMapper.deleteByPrimaryKey(id);
        return id;
    }

    /**
     * 批量删除
     * 
     * @see com.tianque.yunxiao.connect.server.service.GlobalParamService#deleteGlobalParam(java.lang.Long[])
     */
    @Override
    public Long[] deleteGlobalParam(Long[] ids) {
        ValidationUtil.validateNull(ids, null);
        ValidationUtil.validateArrayNullOrEmpty(ids, null);
        globalParamMapper.deleteByIds(ids);
        return ids;
    }

    /**
     * @see com.tianque.yunxiao.connect.server.service.GlobalParamService#selectByPrimaryKey(java.lang.Long)
     */
    @Override
    public GlobalParam selectByPrimaryKey(Long id) {
        logger.info("根据主键查询");
        ValidationUtil.validateNull(id, null);
        return globalParamMapper.selectByPrimaryKey(id);
    }

    /**
     * @see com.tianque.yunxiao.connect.server.service.GlobalParamService#selectByObject(com.tianque.yunxiao.connect.server.model
     *      .GlobalParam)
     */
    @Override
    public GlobalParam selectByObject(GlobalParam globalParam) {
        return selectByPrimaryKey(globalParam.getId());
    }

    /**
     * @see :检查
     * @param :
     * @return : boolean
     * @return
     */
    private boolean checkParamKeyExists(String paramKey) {
        GlobalParam currentGlobalParam = findByParamKeyAndOwner(paramKey,
                SecurityUtils.getUsername());

        return null != currentGlobalParam;
    }

    /**
     * @see :检查
     * @param :
     * @return : boolean
     * @return
     */
    private boolean checkParamKeyExists(GlobalParam globalParam) {
        GlobalParam currentGlobalParam = null;
        if (null != globalParam.getId()) {
            currentGlobalParam = globalParamMapper.selectByObject(globalParam);
        } else {
            currentGlobalParam = findByParamKeyAndOwner(
                    globalParam.getParamKey(), SecurityUtils.getUsername());
        }
        return null != currentGlobalParam;
    }

    // /**
    // * 根据paramKey模糊查询
    // *
    // * @see com.tianque.yunxiao.connect.server.service.GlobalParamService#
    // * searchGlobalParamsByParamKey(java.lang.String)
    // */
    // @Override
    // public List<GlobalParam> searchGlobalParamsByParamKey(
    // String searchContent) {
    // logger.info("根据ParamKey查询记录 {}", searchContent);
    // return globalParamMapper.findGlobalParamsByParamKey(searchContent);
    // }

    /**
     * 根据paramKey唯一查询
     * 
     * @see com.tianque.yunxiao.connect.server.service.GlobalParamService#
     *      findGlobalParamByParamKey(java.lang.String)
     */
    @Override
    public GlobalParam findGlobalParamByParamKey(String paramKey) {
        return globalParamMapper.findGlobalParamByParamKey(paramKey);
    }

    @Override
    public GlobalParam findByParamKey(String paramKey) {
        return globalParamMapper.findGlobalParamByParamKey(paramKey);
    }

    @Override
    public List<GlobalParam> findByLable(String label) {
        return globalParamMapper.findByLabel(label);
    }

    @Override
    public List<GlobalParam> findAll() {
        return globalParamMapper.findAll();
    }

    @Override
    public GlobalParam insertOrUpdate(GlobalParam record) {
        try {

            if (StringUtil.isEmpty(record.getOwner())) {
                record.setOwner(StringUtil.isEmpty(SecurityUtils.getUsername())
                        ? GlobalAuth.DEFUALT_OWNER
                        : SecurityUtils.getUsername());
            }

            logger.debug("record:{}", record);
            if (null == record.getId() || 0 == record.getId()) {
                return addGlobalParam(record);
            } else {
                return updateGlobalParam(record);
            }
        } catch (Exception e) {
            logger.error("新增或者修改全局参数失败:{}", e.getMessage());
            throw new BusinessValidationException("新增或者修改全局参数失败");
        }
    }

    @Override
    public int save(GlobalParam record) {
        insertOrUpdate(record);
        return 0;
    }

    @Override
    public int delete(GlobalParam record) {
        return globalParamMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<GlobalParam> records) {
        for (GlobalParam record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public GlobalParam findById(Long id) {
        return selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Param label = pageRequest.getParam("paramComment");
        if (null != label && StringUtil.isStringAvaliable(label.getValue())) {
            return MybatisPageHelper.findPage(pageRequest, globalParamMapper,
                    "findPageByLabel", label.getValue());
        }
        return MybatisPageHelper.findPage(pageRequest, globalParamMapper);
    }

    @Override
    public GlobalParam findByParamKeyAndOwner(String paramKey, String owner) {
        return globalParamMapper.findByParamKeyAndOwner(paramKey, owner);
    }

}
