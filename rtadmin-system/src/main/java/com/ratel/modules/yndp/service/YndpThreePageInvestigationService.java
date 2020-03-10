package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpThreePageInvestigation;
import com.ratel.modules.yndp.repository.YndpThreePageInvestigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 固定检查点排查Service
 * @author GXP
 * @date 2020/2/27 17:22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpThreePageInvestigationService extends BaseService<YndpThreePageInvestigation, String> {

    @Autowired
    private YndpThreePageInvestigationRepository YndpThreePageInvestigationRepository;

    public YndpThreePageInvestigation getYndpThreePageInvestigation(String date) {
        return YndpThreePageInvestigationRepository.getYndpThreePageInvestigation(date);
    }
}
