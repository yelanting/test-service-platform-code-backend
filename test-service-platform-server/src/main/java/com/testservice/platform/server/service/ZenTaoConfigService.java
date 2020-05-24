/**
 * 
 */
package com.testservice.platform.server.service;

import java.util.List;

import com.testservice.platform.server.model.GlobalParam;

/**
 * @author Administrator
 *
 */
public interface ZenTaoConfigService {
    GlobalParam save(GlobalParam record);

    List<GlobalParam> getCurrentZenTaoData();
}
