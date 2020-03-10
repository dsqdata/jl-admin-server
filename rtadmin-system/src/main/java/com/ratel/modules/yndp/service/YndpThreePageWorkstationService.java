package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpThreePageWorkstation;
import com.ratel.modules.yndp.repository.YndpThreePageWorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 留验站工作表Service
 * @author GXP
 * @date 2020/2/27 17:22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpThreePageWorkstationService extends BaseService<YndpThreePageWorkstation, String> {

    @Autowired
    private YndpThreePageWorkstationRepository YndpThreePageWorkstationRepository;

    public List<YndpThreePageWorkstation> getYndpThreePageWorkstationList() {
        return YndpThreePageWorkstationRepository.getYndpThreePageWorkstationList();
    }
}
