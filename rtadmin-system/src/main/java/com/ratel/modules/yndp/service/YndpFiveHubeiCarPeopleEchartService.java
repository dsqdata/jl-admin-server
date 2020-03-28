package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFiveHubeiCarPeopleEchart;
import com.ratel.modules.yndp.repository.YndpFiveHubeiCarPeopleEchartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 湖北入昆车辆人员图表Service
 * @author GXP
 * @date 2020/2/27 17:22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFiveHubeiCarPeopleEchartService extends BaseService<YndpFiveHubeiCarPeopleEchart, String> {

    @Autowired
    private YndpFiveHubeiCarPeopleEchartRepository YndpFiveHubeiCarPeopleEchartRepository;

    //根据日期查询之前所有日期的湖北入昆车辆人员图表
    public List<YndpFiveHubeiCarPeopleEchart> getYndpFiveHubeiCarPeopleEchartList(String date) {
        return YndpFiveHubeiCarPeopleEchartRepository.getYndpFiveHubeiCarPeopleEchartList(date);
    }
}
