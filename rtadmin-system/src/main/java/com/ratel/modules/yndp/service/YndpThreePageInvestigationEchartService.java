package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpThreePageInvestigationEchart;
import com.ratel.modules.yndp.domain.YndpThreePageRework;
import com.ratel.modules.yndp.repository.YndpQyfgfcRepository;
import com.ratel.modules.yndp.repository.YndpThreePageInvestigationEchartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 企业复工复产情况
 * @author xjl
 * @date 2020/3/9
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpThreePageInvestigationEchartService extends BaseService<YndpThreePageRework, String> {

    @Autowired
    private YndpThreePageInvestigationEchartRepository yndpThreePageInvestigationEchartRepository;

    public List<YndpThreePageInvestigationEchart> getGdjcpcEList(String date) {
        return yndpThreePageInvestigationEchartRepository.getGdjcpcEList(date);
    }
}
