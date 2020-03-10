package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpThreePageCheck;
import com.ratel.modules.yndp.repository.YndpThreePageCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 三类重点目标人群核查Service
 * @author GXP
 * @date 2020/2/27 17:22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpThreePageCheckService extends BaseService<YndpThreePageCheck, String> {

    @Autowired
    private YndpThreePageCheckRepository YndpThreePageCheckRepository;

    public YndpThreePageCheck getYndpThreePageCheck(String date) {
        return YndpThreePageCheckRepository.getYndpThreePageCheck(date);
    }
}
