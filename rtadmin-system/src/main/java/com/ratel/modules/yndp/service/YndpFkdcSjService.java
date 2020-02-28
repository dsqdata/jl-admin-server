package com.ratel.modules.yndp.service;


import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFkdcSj;
import com.ratel.modules.yndp.repository.YndpFkdcSjRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 中间地图事件service
 * @author DDXS
 * @date 2020/2/28 9:09
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFkdcSjService  extends BaseService<YndpFkdcSj, String> {

    @Autowired
    YndpFkdcSjRepository yndpFkdcSjRepository;

    public List<YndpFkdcSj> getMapSjList(String jgId) {
        return yndpFkdcSjRepository.getMapSjList(jgId);
    }
}
