package com.testservice.platform.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testservice.platform.server.dao.PlatformMapper;
import com.testservice.platform.server.model.Platform;
import com.testservice.platform.server.page.MybatisPageHelper;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.page.PageResult;
import com.testservice.platform.server.page.Param;
import com.testservice.platform.server.service.PlatformService;
import com.testservice.platform.server.util.HttpUtils;

@Service("platformService")
public class PlatformServiceImpl implements PlatformService {

	@Autowired
	private PlatformMapper platformMapper;

	@Override
	public int save(Platform record) {

		record.setImageUrl(HttpUtils.getFavico(record.getAccessUrl()));
		if (record.getId() == null || record.getId() == 0) {
			return platformMapper.insert(record);
		}

		return platformMapper.updateByPrimaryKey(record);
	}

	@Override
	public int delete(Platform record) {
		return platformMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<Platform> records) {
		for (Platform record : records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public Platform findById(Long id) {
		return platformMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Param label = pageRequest.getParam("platformName");
		if (label != null) {
			return MybatisPageHelper.findPage(pageRequest, platformMapper,
			        "findPageByPlatformName", label.getValue());
		}
		return MybatisPageHelper.findPage(pageRequest, platformMapper);
	}

	@Override
	public Platform findByPlatformName(String platformName) {
		return platformMapper.findByPlatformName(platformName);
	}

	@Override
	public List<Platform> findAll() {
		return platformMapper.findAll();
	}

}
