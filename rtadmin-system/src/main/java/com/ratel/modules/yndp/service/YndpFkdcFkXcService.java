package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFkdcFkxc;
import com.ratel.modules.yndp.domain.YndpFkdcWzbz;
import com.ratel.modules.yndp.repository.YndpFkdcFkxcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 防控宣传service
 * @author DDXS
 * @date 2020/2/26 13:37
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFkdcFkXcService extends BaseService<YndpFkdcWzbz, String> {

    @Autowired
    private YndpFkdcFkxcRepository yndpFkdcFkxcRepository;

    public List<YndpFkdcFkxc> getFkxcList(String jgId) {
        return yndpFkdcFkxcRepository.getFkxcList(jgId);
    }
}
