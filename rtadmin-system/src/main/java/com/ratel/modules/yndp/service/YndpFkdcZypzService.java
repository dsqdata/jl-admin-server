package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFkdcWzbz;
import com.ratel.modules.yndp.domain.YndpFkdcZypz;
import com.ratel.modules.yndp.repository.YndpFjdcZypzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 资源配置service
 * @author DDXS
 * @date 2020/2/26 13:38
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFkdcZypzService extends BaseService<YndpFkdcWzbz,Integer> {

    @Autowired
    private YndpFjdcZypzRepository yndpFjdcZypzRepository;

    // 根据机构id查询出列表
    public List<YndpFkdcZypz> findListByJgId(String jgId) {
        return yndpFjdcZypzRepository.findListByJgId(jgId);
    }
}
