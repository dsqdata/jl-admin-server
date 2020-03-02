package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFkdcZypz;
import com.ratel.modules.yndp.repository.YndpFkdcZypzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 资源配置service
 * @author DDXS
 * @date 2020/2/26 13:38
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFkdcZypzService extends BaseService<YndpFkdcZypz,String> {

    @Autowired
    private YndpFkdcZypzRepository yndpFkdcZypzRepository;

    // 根据机构id查询数据
    public YndpFkdcZypz findZypzByJgId(String jgId) {
        return yndpFkdcZypzRepository.findZypzByJgId(jgId);
    }
}
