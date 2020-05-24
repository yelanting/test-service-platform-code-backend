package com.testservice.platform.server.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.testservice.platform.server.model.Apk;

/**
 * 字典管理
 * 
 * @author administrator
 * @date Jan 13, 2019
 */
public interface ApkService extends CurdService<Apk> {
	/**
	 * 根据名称查询
	 * 
	 * @param name
	 * @return
	 */
	Apk findByName(String name);

	/**
	 * 根据包名称查询
	 * 
	 * @see :
	 * @param :
	 * @return : Apk
	 * @param packageName
	 * @return
	 */
	Apk findByPackageName(String packageName);

	List<Apk> findByLable(@Param(value = "label") String label);

	List<Apk> findAll();

	/**
	 * 插入返回实体
	 * 
	 * @see :
	 * @param :
	 * @return : Apk
	 * @param record
	 * @return
	 */
	Apk insertOrUpdate(Apk record);
}
