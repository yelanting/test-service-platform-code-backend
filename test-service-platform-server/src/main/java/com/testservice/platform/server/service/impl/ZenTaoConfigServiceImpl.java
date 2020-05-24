/**
 * 
 */
package com.testservice.platform.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testservice.platform.server.constant.SysInitDataConstants;
import com.testservice.platform.server.model.GlobalParam;
import com.testservice.platform.server.service.GlobalParamService;
import com.testservice.platform.server.service.ZenTaoConfigService;
import com.testservice.platform.server.util.SecurityUtils;
import com.testservice.platform.util.core.StringUtil;

/**
 * @author Administrator
 *
 */
@Service("zenTaoConfigService")
public class ZenTaoConfigServiceImpl implements ZenTaoConfigService {

    @Autowired
    private GlobalParamService globalParamService;

    @Override
    public GlobalParam save(GlobalParam record) {
        if (StringUtil.isEmpty(record.getOwner())) {
            record.setOwner(SecurityUtils.getUsername());
        }

        return globalParamService.insertOrUpdate(record);
    }

    @Override
    public List<GlobalParam> getCurrentZenTaoData() {
        String username = SecurityUtils.getUsername();

        GlobalParam zenTaoUrl = globalParamService.findByParamKeyAndOwner(
                SysInitDataConstants.GlobalParamInitConst.ZENTAO_URL_KEY,
                username);
        GlobalParam zenTaoLoginUsername = globalParamService
                .findByParamKeyAndOwner(
                        SysInitDataConstants.GlobalParamInitConst.ZENTAO_LOGIN_USERNAME_KEY,
                        username);
        GlobalParam zenTaoLoginPassword = globalParamService
                .findByParamKeyAndOwner(
                        SysInitDataConstants.GlobalParamInitConst.ZENTAO_LOGIN_PASSWORD_KEY,
                        username);
        List<GlobalParam> currentConfiGlobalParams = new ArrayList<>();

        if (null != zenTaoUrl) {
            currentConfiGlobalParams.add(zenTaoUrl);
        }

        if (null != zenTaoLoginUsername) {

            currentConfiGlobalParams.add(zenTaoLoginUsername);
        }

        if (null != zenTaoLoginPassword) {

            currentConfiGlobalParams.add(zenTaoLoginPassword);
        }
        return currentConfiGlobalParams;
    }

}
