package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpThreePageReworkEchart;
import com.ratel.modules.yndp.repository.YndpThreePageReworkEchartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 企业复工复产Echart图Service
 * @author GXP
 * @date 2020/2/27 17:22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpThreePageReworkEchartService extends BaseService<YndpThreePageReworkEchart, String> {

    @Autowired
    private YndpThreePageReworkEchartRepository YndpThreePageReworkEchartRepository;

    //根据日期查询之前所有日期的企业复工复产Echart
    public List<YndpThreePageReworkEchart> getYndpThreePageReworkEchartList(String date) {
        return YndpThreePageReworkEchartRepository.getYndpThreePageReworkEchartList(date);
    }
}
