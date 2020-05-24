package com.testservice.platform.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.testservice.platform.server.model.SysDept;

public interface SysDeptMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SysDept record);

	int insertSelective(SysDept record);

	SysDept selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysDept record);

	int updateByPrimaryKey(SysDept record);

	List<SysDept> findPage();

	List<SysDept> findAll();

	/**
	 * 根据父级id和部门名称，查找部门
	 * 
	 * @see :
	 * @param :
	 * @return : SysDept
	 * @param deptName
	 * @param parentId
	 * @return
	 */
	SysDept findByNameAndParentId(@Param("deptName") String deptName,
	        @Param("parentId") Long parentId);

	/**
	 * 获取顶层部门
	 * 
	 * @see :
	 * @param :
	 * @return : SysDept
	 * @param deptName
	 * @return
	 */
	SysDept findTopDeptByName(String deptName);
}