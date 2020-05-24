package com.testservice.platform.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * 启动器
 * 
 * @author administrator
 * @date Jan 15, 2019
 */
@EnableAdminServer
@SpringBootApplication
public class TestServicePlatformMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestServicePlatformMonitorApplication.class,
                args);
    }
}