package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFiveHubeiCriticalJunctureReturnEchart;
import com.ratel.modules.yndp.repository.YndpFiveHubeiCriticalJunctureReturnEchartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 湖北返回情况echart图表Service
 * @author GXP
 * @date 2020/2/27 17:22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFiveHubeiCriticalJunctureReturnEchartService extends BaseService<YndpFiveHubeiCriticalJunctureReturnEchart, String> {

    @Autowired
    private YndpFiveHubeiCriticalJunctureReturnEchartRepository YndpFiveHubeiCriticalJunctureReturnEchartRepository;

    //根据日期查询之前所有日期的湖北返回情况echart图表
    public List<YndpFiveHubeiCriticalJunctureReturnEchart> getYndpFiveHubeiCriticalJunctureReturnEchartList(String date) {
        return YndpFiveHubeiCriticalJunctureReturnEchartRepository.getYndpFiveHubeiCriticalJunctureReturnEchartList(date);
    }
}
