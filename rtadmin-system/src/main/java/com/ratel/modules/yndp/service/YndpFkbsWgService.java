package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFkbsJg;
import com.ratel.modules.yndp.domain.YndpFkbsWg;
import com.ratel.modules.yndp.repository.YndpFkbsWgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 防控部署-网格service
 * @author DDXS
 * @date 2020/2/28 12:28
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFkbsWgService extends BaseService<YndpFkbsWg, String> {

    @Autowired
    YndpFkbsWgRepository yndpFkbsWgRepository;

    // 根据机构ID查询出所有网格
    public List<YndpFkbsWg> getWgList(String jgId) {
        return yndpFkbsWgRepository.getWgList(jgId);
    }
}
