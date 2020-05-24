package com.testservice.platform.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.testservice.platform.server.model.Apk;

public interface ApkMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Apk record);

	Apk insertAndReturnObject(Apk record);

	int insertSelective(Apk record);

	Apk selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Apk record);

	int updateByPrimaryKey(Apk record);

	List<Apk> findPage();

	List<Apk> findPageByName(@Param(value = "name") String name);

	List<Apk> findByLable(@Param(value = "label") String label);

	Apk findByName(@Param(value = "name") String name);

	Apk findByPackageName(@Param(value = "packageName") String packageName);

	List<Apk> findAll();
}