package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFiveHubeiPeople;
import com.ratel.modules.yndp.repository.YndpFiveHubeiPeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 严防外源输入-湖北入昆人员Service
 * @author GXP
 * @date 2020/2/27 17:22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFiveHubeiPeopleService extends BaseService<YndpFiveHubeiPeople, String> {

    @Autowired
    private YndpFiveHubeiPeopleRepository YndpFiveHubeiPeopleRepository;

    public YndpFiveHubeiPeople getYndpFiveHubeiPeople(String date) {
        return YndpFiveHubeiPeopleRepository.getYndpFiveHubeiPeople(date);
    }
}
