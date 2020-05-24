package com.testservice.platform.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.testservice.platform.server.model.Platform;

public interface PlatformMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Platform record);

	int insertSelective(Platform record);

	Platform selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Platform record);

	int updateByPrimaryKey(Platform record);

	List<Platform> findPage();

	List<Platform> findPageByName(@Param(value = "name") String name);

	List<Platform> findByLable(@Param(value = "label") String label);

	List<Platform> findPageByPlatformName(
	        @Param(value = "platformName") String platformName);

	Platform findByName(@Param(value = "name") String name);

	Platform findByPlatformName(
	        @Param(value = "platformName") String platformName);

	List<Platform> findAll();
}