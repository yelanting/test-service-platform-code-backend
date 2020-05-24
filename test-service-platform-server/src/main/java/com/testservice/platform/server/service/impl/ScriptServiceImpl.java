package com.testservice.platform.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testservice.platform.server.dao.ScriptMapper;
import com.testservice.platform.server.model.Script;
import com.testservice.platform.server.page.MybatisPageHelper;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.page.PageResult;
import com.testservice.platform.server.page.Param;
import com.testservice.platform.server.service.ApkService;
import com.testservice.platform.server.service.ScriptService;

@Service("scriptService")
public class ScriptServiceImpl implements ScriptService {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(ScriptServiceImpl.class);
	@Autowired
	private ScriptMapper scriptMapper;

	@Autowired
	private ApkService apkService;

	@Override
	public int save(Script record) {
		LOGGER.debug("record:{}", record);
		if (record.getId() == null || record.getId() == 0) {
			// record.setCreateBy(GlobalAuth.USERNAME);
			// record.setLastUpdateBy(GlobalAuth.USERNAME);
			return scriptMapper.insert(record);
		}

		// record.setLastUpdateBy(GlobalAuth.USERNAME);
		return scriptMapper.updateByPrimaryKey(record);
	}

	@Override
	public int delete(Script record) {
		return scriptMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<Script> records) {
		for (Script record : records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public Script findById(Long id) {
		return dealWithScript(scriptMapper.selectByPrimaryKey(id));
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Param label = pageRequest.getParam("label");
		PageResult pageResult = null;
		if (label != null) {
			pageResult = MybatisPageHelper.findPage(pageRequest, scriptMapper,
			        "findPageByLabel", label.getValue());
		} else {
			pageResult = MybatisPageHelper.findPage(pageRequest, scriptMapper);
		}
		List<Script> scripts = (List<Script>) pageResult.getContent();
		pageResult.setContent(dealWithScripts(scripts));
		return pageResult;
	}

	@Override
	public PageResult findPageByAppId(PageRequest pageRequest) {
		LOGGER.debug("分页请求全部参数为:{}", pageRequest);
		Param label = pageRequest.getParam("appId");

		PageResult pageResult = null;
		if (label != null) {
			LOGGER.debug("根据appId:{}查询分页", label.getValue());
			pageResult = MybatisPageHelper.findPage(pageRequest, scriptMapper,
			        "findPageByAppId", Long.parseLong(label.getValue()));
		} else {
			pageResult = MybatisPageHelper.findPage(pageRequest, scriptMapper);
		}

		List<Script> scripts = (List<Script>) pageResult.getContent();
		pageResult.setContent(dealWithScripts(scripts));
		return pageResult;
	}

	@Override
	public Script findByScriptName(String scriptName) {
		return dealWithScript(scriptMapper.findByScriptName(scriptName));
	}

	@Override
	public List<Script> findByPackageName(String packageName) {
		return dealWithScripts(scriptMapper.findByPackageName(packageName));
	}

	@Override
	public List<Script> findByLable(String label) {
		List<Script> pageByLabel = scriptMapper.findByLable(label);
		return dealWithScripts(pageByLabel);
	}

	@Override
	public List<Script> findAll() {
		List<Script> allScripts = scriptMapper.findAll();

		return dealWithScripts(allScripts);
	}

	/**
	 * 处理相关属性
	 * 
	 * @see :
	 * @param :
	 * @return : List<Script>
	 * @param script
	 * @return
	 */
	private List<Script> dealWithScripts(List<Script> scripts) {
		// for (Script script : scripts) {
		// script = dealWithScript(script);
		// }

		return scripts;
	}

	/**
	 * 处理相关属性
	 * 
	 * @see :
	 * @param :
	 * @return : Script
	 * @param script
	 * @return
	 */
	private Script dealWithScript(Script script) {
		// if (null != script.getAppId()) {
		// script.setApk(apkService.findById(script.getAppId()));
		// }

		return script;
	}

	@Override
	public List<Script> findAllByAppId(Long appId) {
		return scriptMapper.findAllByAppId(appId);
	}

}
