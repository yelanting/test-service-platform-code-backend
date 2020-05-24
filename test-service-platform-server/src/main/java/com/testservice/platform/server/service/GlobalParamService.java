/**
 * @author : 孙留平
 * @since : 2019年5月7日 下午6:48:56
 * @see:
 */
package com.testservice.platform.server.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.testservice.platform.server.model.GlobalParam;

/**
 * @author : Administrator
 * @since : 2019年5月7日 下午6:48:56
 * @see :
 */
public interface GlobalParamService extends CurdService<GlobalParam> {
    /**
     * 查询列表
     * 
     * @see : 获取列表
     * @param :
     * @return : List<GlobalParam>
     * @return
     */
    List<GlobalParam> getList();

    /**
     * 添加全局参数
     * 
     * @see :
     * @param :
     * @return : GlobalParam
     * @param globalParam
     * @return
     */
    GlobalParam addGlobalParam(GlobalParam globalParam);

    /**
     * 修改数据
     * 
     * @see :
     * @param :
     * @return : GlobalParam
     * @param globalParam
     * @return
     */
    GlobalParam updateGlobalParam(GlobalParam globalParam);

    /**
     * 根据搜索内容查询列表
     * 
     * @see :
     * @param :
     * @return : List<GlobalParam>
     * @param searchContent
     * @return
     */
    List<GlobalParam> searchGlobalParamsBySearchContent(String searchContent);

    // /**
    // * 根据paramKey查询
    // *
    // * @see :
    // * @param :
    // * @return : List<GlobalParam>
    // * @param searchContent
    // * @return
    // */
    // List<GlobalParam> searchGlobalParamsByParamKey(String searchContent);

    /**
     * 根据paramKey查询
     * 
     * @see :
     * @param :
     * @return : List<GlobalParam>
     * @param paramKey
     * @return
     */
    GlobalParam findGlobalParamByParamKey(String paramKey);

    /**
     * 单个删除
     * 
     * @see :
     * @param :
     * @return : void
     * @param id
     */
    Long deleteGlobalParam(Long id);

    /**
     * 批量删除
     * 
     * @see :
     * @param :
     * @return : void
     * @param ids
     */
    Long[] deleteGlobalParam(Long[] ids);

    /**
     * 根据主键查询
     * 
     * @see : 根据主键查询
     * @param :
     * @return : GlobalParam
     * @param id
     * @return
     */
    GlobalParam selectByPrimaryKey(Long id);

    /**
     * 根据对象查询
     * 
     * @see : 根据具体对象查询
     * @param :
     * @return : GlobalParam
     * @param globalParam
     * @return
     */
    GlobalParam selectByObject(GlobalParam globalParam);

    /**
     * 根据名称查询
     * 
     * @param name
     * @return
     */
    GlobalParam findByParamKey(String paramKey);

    /**
     * 根据参数注释来查找
     * 
     * @see :
     * @param :
     * @return : List<GlobalParam>
     * @param label
     * @return
     */
    List<GlobalParam> findByLable(@Param(value = "label") String label);

    List<GlobalParam> findAll();

    /**
     * 插入返回实体
     * 
     * @see :
     * @param :
     * @return : GlobalParam
     * @param record
     * @return
     */
    GlobalParam insertOrUpdate(GlobalParam record);

    /**
     * 
     * @param paramKey
     * @param owner
     * @return: GlobalParam
     */
    GlobalParam findByParamKeyAndOwner(String paramKey, String owner);
}
