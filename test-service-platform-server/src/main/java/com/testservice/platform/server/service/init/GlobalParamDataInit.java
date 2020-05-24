/**
 * @author 作者: 孙留平
 * @since 创建时间: 2019年8月2日 下午2:54:03
 * @see:
 */
package com.testservice.platform.server.service.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testservice.platform.server.constant.SysInitDataConstants;
import com.testservice.platform.server.global.GlobalAuth;
import com.testservice.platform.server.model.GlobalParam;
import com.testservice.platform.server.service.GlobalParamService;
import com.testservice.platform.zentao.api.define.ConstDefine;

@Service("globalParamDataInit")
public class GlobalParamDataInit {

    @Autowired
    private GlobalParamService globalParamService;

    @PostConstruct
    public void initZenTaoData() {
        checkAndInitGlobalParam(
                SysInitDataConstants.GlobalParamInitConst.ZENTAO_URL_KEY,
                new GlobalParam(
                        SysInitDataConstants.GlobalParamInitConst.ZENTAO_URL_KEY,
                        ConstDefine.DEFAULT_ZENTAO_URL, "禅道登录url"));

        checkAndInitGlobalParam(
                SysInitDataConstants.GlobalParamInitConst.ZENTAO_LOGIN_USERNAME_KEY,
                new GlobalParam(
                        SysInitDataConstants.GlobalParamInitConst.ZENTAO_LOGIN_USERNAME_KEY,
                        ConstDefine.DEFAULT_LOGIN_ROOT_USER, "禅道登录用户"));
        checkAndInitGlobalParam(
                SysInitDataConstants.GlobalParamInitConst.ZENTAO_LOGIN_PASSWORD_KEY,
                new GlobalParam(
                        SysInitDataConstants.GlobalParamInitConst.ZENTAO_LOGIN_PASSWORD_KEY,
                        ConstDefine.DEFAULT_LOGIN_ROOT_PASSWORD, "禅道登录密码"));
    }

    /**
     * 判断一下，如果当前key不存在，就初始化一下
     * 
     * @see :
     * @param :
     * @return : void
     * @param paramKey
     * @param globalParam
     */
    private void checkAndInitGlobalParam(String paramKey,
            GlobalParam globalParam) {
        if (null == globalParamService.findByParamKeyAndOwner(paramKey,
                GlobalAuth.DEFUALT_OWNER)) {
            globalParam.setOwner(GlobalAuth.DEFUALT_OWNER);
            globalParamService.addGlobalParam(globalParam);
        }
    }
}
