/**
 * @author : 孙留平
 * @since : 2020年3月18日 下午5:21:01
 * @see:
 */
package com.testservice.platform.server.zentao.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.testservice.platform.server.zentao.entity.ZenTaoServerInfo;
import com.testservice.platform.zentao.api.define.ConstDefine;
import com.testservice.platform.zentao.api.entity.ZenTaoApiResponseObject;
import com.testservice.platform.util.core.JsonUtil;
import com.testservice.platform.util.core.StringUtil;
import com.testservice.platform.util.exception.base.BusinessValidationException;

/**
 * @author : Administrator
 * @since : 2020年3月18日 下午5:21:01
 * @see :
 */
public class ZenTaoUtil {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ZenTaoUtil.class);

    /**
     * 
     * @see : 处理Url
     * @param :
     * @return : String
     * @param pathUrl
     * @return
     */
    public static String dealWithUrl(String pathUrl) {
        return dealWithUrl(pathUrl, ConstDefine.DEFAULT_ZENTAO_URL);
    }

    /**
     * 
     * @see : 处理Url
     * @param :
     * @return : String
     * @param pathUrl
     * @return
     */
    public static String dealWithUrl(String pathUrl, String baseUrl) {

        if (baseUrl.isEmpty()) {
            baseUrl = ConstDefine.DEFAULT_ZENTAO_URL;
        }

        if (StringUtil.isEmpty(pathUrl)) {
            return baseUrl;
        }

        if (!baseUrl.endsWith("/")) {
            baseUrl += "/";
        }

        if (pathUrl.startsWith("/")) {
            pathUrl = pathUrl.substring(1);
        }

        String finalUrl = baseUrl + pathUrl;
        LOGGER.debug("最终的url为:{}", finalUrl);
        return finalUrl;
    }

    /**
     * 
     * @see : 处理Url
     * @param :
     * @return : String
     * @param pathUrl
     * @return
     */
    public static String dealWithUrl(String pathUrl,
            ZenTaoServerInfo zenTaoServerInfo) {
        if (null == zenTaoServerInfo) {
            return dealWithUrl(pathUrl);
        }
        return dealWithUrl(pathUrl, zenTaoServerInfo.getZenTaoServerUrl());
    }

    /**
     * 从响应正文解析
     * 
     * @see :
     * @param :
     * @return : ZenTaoApiResponseObject
     * @param responseText
     * @return
     */
    public static ZenTaoApiResponseObject parseZenTaoApiResponseObjectFromResponseText(
            String responseText) {
        ZenTaoApiResponseObject zenTaoApiResponseObject;
        zenTaoApiResponseObject = JsonUtil.jsonToObject(responseText,
                ZenTaoApiResponseObject.class);

        if (null == zenTaoApiResponseObject) {
            throw new BusinessValidationException("禅道响应转换失败，转换结果为null");
        }

        LOGGER.debug("zenTaoApiResponseObject:{}", zenTaoApiResponseObject);
        return zenTaoApiResponseObject;
    }

    /**
     * 从响应对象中解析需要的对象
     * 
     * @see :
     * @param :
     * @return : T
     * @param responseText
     * @return
     */
    public static <T> T parseObjectFromZenTaoApiResponse(
            ZenTaoApiResponseObject zenTaoApiResponseObject,
            Class<T> classType) {
        T result = null;
        try {
            result = JsonUtil.jsonToObject(zenTaoApiResponseObject.getData(),
                    classType);
            LOGGER.debug("zenTaoApiResponseObject:{}", zenTaoApiResponseObject);
            return result;
        } catch (Exception e) {
            LOGGER.error("转换响应失败:{}", e.getMessage());
            throw new BusinessValidationException("禅道响应转换出错");
        }
    }

    /**
     * 从返回的响应中找字段，比如data:{"title":"","case":{"title":""}}
     * 
     * @see : 类似从data中找case
     * @param :
     * @return : void
     * @param <T>
     * @param zenTaoApiResponseObject
     * @param childKeyUnderData
     * @param classType
     */
    public static <T> T parseObjectFromZenTaoApiResponseObjectData(
            ZenTaoApiResponseObject zenTaoApiResponseObject,
            String childKeyUnderData, Class<T> classType) {
        T result = null;
        try {
            Object data = zenTaoApiResponseObject.getData();

            JSONObject dataJsonObject = JSONObject.parseObject(data.toString());

            if (!dataJsonObject.containsKey(childKeyUnderData)) {
                return null;
            }

            JSONObject keyObject = dataJsonObject
                    .getJSONObject(childKeyUnderData);

            if (keyObject.toString().equals("[]")
                    || keyObject.toString().equals("{}")) {
                return null;
            }

            result = JsonUtil.jsonToObject(keyObject, classType);
            LOGGER.debug("result:{}", result);
            return result;
        } catch (Exception e) {
            LOGGER.error("转换响应失败:{}", e.getMessage());
            throw new BusinessValidationException("禅道响应转换出错");
        }
    }
}
