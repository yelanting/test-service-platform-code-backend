package com.testservice.platform.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.testservice.platform.server.model.Script;

public interface ScriptMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Script record);

	int insertSelective(Script record);

	Script selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Script record);

	int updateByPrimaryKey(Script record);

	List<Script> findPage();

	List<Script> findPageByLabel(@Param(value = "label") String label);

	List<Script> findPageByAppId(@Param(value = "appId") Long appId);

	List<Script> findByLable(@Param(value = "label") String label);

	Script findByScriptName(@Param(value = "scriptName") String scriptName);

	List<Script> findByPackageName(
	        @Param(value = "packageName") String packageName);

	List<Script> findAll();

	List<Script> findAllByAppId(Long appId);
}