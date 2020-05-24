package com.testservice.platform.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.testservice.platform.server.model.ZenTaoTestTaskModel;

public interface ZenTaoTestTaskModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ZenTaoTestTaskModel record);

    ZenTaoTestTaskModel insertAndReturnObject(ZenTaoTestTaskModel record);

    int insertSelective(ZenTaoTestTaskModel record);

    ZenTaoTestTaskModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ZenTaoTestTaskModel record);

    int updateByPrimaryKey(ZenTaoTestTaskModel record);

    List<ZenTaoTestTaskModel> findPage();

    List<ZenTaoTestTaskModel> findByLable(@Param(value = "label") String label);

    List<ZenTaoTestTaskModel> findAll();

    List<ZenTaoTestTaskModel> findPageByLabel(
            @Param(value = "label") String label);

    List<ZenTaoTestTaskModel> filterCurrentUserTestTaskModelsByUsername(
            @Param(value = "username") String username);
}