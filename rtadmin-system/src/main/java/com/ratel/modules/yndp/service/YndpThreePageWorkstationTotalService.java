package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpThreePageWorkstationTotal;
import com.ratel.modules.yndp.repository.YndpThreePageWorkstationTotalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 留验站工作动态Service
 * @author GXP
 * @date 2020/2/27 17:22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpThreePageWorkstationTotalService extends BaseService<YndpThreePageWorkstationTotal, String> {

    @Autowired
    private YndpThreePageWorkstationTotalRepository YndpThreePageWorkstationTotalRepository;

    public YndpThreePageWorkstationTotal getYndpThreePageWorkstationTotal(String date,String workstation_id) {
        return YndpThreePageWorkstationTotalRepository.getYndpThreePageWorkstationTotal(date,workstation_id);
    }
}
