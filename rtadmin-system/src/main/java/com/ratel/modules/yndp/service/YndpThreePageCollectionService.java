package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpThreePageCollection;
import com.ratel.modules.yndp.repository.YndpThreePageCollectionRepository;
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
public class YndpThreePageCollectionService extends BaseService<YndpThreePageCollection, String> {

    @Autowired
    private YndpThreePageCollectionRepository YndpThreePageCollectionRepository;

    //根据日期查询社区/村人员核查和信息采集
    public YndpThreePageCollection getYndpThreePageCollection(String date) {
        return YndpThreePageCollectionRepository.getYndpThreePageCollection(date);
    }

}
