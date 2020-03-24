package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFourDate;
import com.ratel.modules.yndp.repository.YndpFourDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 校园疫情防控-数据更新时间Service
 * @author GXP
 * @date 2020/2/27 17:22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFourDateService extends BaseService<YndpFourDate, String> {

    @Autowired
    private YndpFourDateRepository YndpFourDateRepository;

    public YndpFourDate getYndpFourDate() {
        return YndpFourDateRepository.getYndpFourDate();
    }
}
