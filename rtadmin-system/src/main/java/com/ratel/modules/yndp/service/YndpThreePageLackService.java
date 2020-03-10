package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpThreePageLack;
import com.ratel.modules.yndp.repository.YndpThreePageLackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 紧缺物资Service
 * @author GXP
 * @date 2020/2/27 17:22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpThreePageLackService extends BaseService<YndpThreePageLack, String> {

    @Autowired
    private YndpThreePageLackRepository YndpThreePageLackRepository;

    public List<YndpThreePageLack> getYndpThreePageLackList(String date) {
        return YndpThreePageLackRepository.getYndpThreePageLackList(date);
    }
}
