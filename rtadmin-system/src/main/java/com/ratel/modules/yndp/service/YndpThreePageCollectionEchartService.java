package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpThreePageCollectionEchart;
import com.ratel.modules.yndp.repository.YndpThreePageCollectionEchartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 社区/村人员核查和信息采集Service
 * @author GXP
 * @date 2020/2/27 17:22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpThreePageCollectionEchartService extends BaseService<YndpThreePageCollectionEchart, String> {

    @Autowired
    private YndpThreePageCollectionEchartRepository YndpThreePageCollectionEchartRepository;

    //根据日期查询之前所有日期的社区/村人员核查和信息采集
    public List<YndpThreePageCollectionEchart> getYndpThreePageCollectionEchartList(String date) {
        return YndpThreePageCollectionEchartRepository.getYndpThreePageCollectionEchartList(date);
    }
}
