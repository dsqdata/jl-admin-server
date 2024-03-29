package com.ratel.modules.monitor.config;

import com.ratel.modules.monitor.service.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 初始化站点统计
 */
@Component
public class VisitsInitialization implements ApplicationRunner {

    @Autowired
    private VisitsService visitsService;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("--------------- 初始化站点统计，如果存在今日统计则跳过 ---------------");
        visitsService.save();
        System.out.println("--------------- 初始化站点统计完成 ---------------");
    }
}
