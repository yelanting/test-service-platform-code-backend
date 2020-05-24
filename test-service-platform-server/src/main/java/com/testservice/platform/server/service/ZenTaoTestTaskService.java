/**
 * @author : 孙留平
 * @since : 2020年3月18日 上午1:09:10
 * @see:
 */
package com.testservice.platform.server.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.testservice.platform.server.model.ZenTaoTestTaskModel;
import com.testservice.platform.server.zentao.entity.ZenTaoTestTask;

/**
 * @author : Administrator
 * @since : 2020年3月18日 上午1:09:10
 * @see :
 */
public interface ZenTaoTestTaskService
        extends CurdService<ZenTaoTestTaskModel> {
    /**
     * 获取测试单信息
     */
    ZenTaoTestTask findZenTaoTestTaskById(Long id);

    List<ZenTaoTestTaskModel> findAll();

    ZenTaoTestTaskModel insertOrUpdate(ZenTaoTestTaskModel record);

    List<ZenTaoTestTaskModel> findByLable(@Param(value = "label") String label);

    List<ZenTaoTestTaskModel> findAllByUsername(
            @Param(value = "username") String username);
}
