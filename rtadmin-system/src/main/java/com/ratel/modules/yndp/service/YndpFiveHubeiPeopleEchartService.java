package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFiveHubeiPeopleEchart;
import com.ratel.modules.yndp.repository.YndpFiveHubeiPeopleEchartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 湖北入昆人员图表Service
 * @author GXP
 * @date 2020/2/27 17:22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFiveHubeiPeopleEchartService extends BaseService<YndpFiveHubeiPeopleEchart, String> {

    @Autowired
    private YndpFiveHubeiPeopleEchartRepository YndpFiveHubeiPeopleEchartRepository;

    //根据日期查询之前所有日期的湖北入昆人员图表
    public List<YndpFiveHubeiPeopleEchart> getYndpFiveHubeiPeopleEchartList(String date) {
        return YndpFiveHubeiPeopleEchartRepository.getYndpFiveHubeiPeopleEchartList(date);
    }
}
