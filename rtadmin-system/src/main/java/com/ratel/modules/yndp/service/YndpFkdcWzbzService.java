package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFkdcWzbz;
import com.ratel.modules.yndp.repository.YndpFkdcWzbzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 物资保障service
 * @author DDXS
 * @date 2020/2/26 13:37
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFkdcWzbzService extends BaseService<YndpFkdcWzbz, String> {

    @Autowired
    private YndpFkdcWzbzRepository yndpFkdcWzbzRepository;

    // 根据机构id查询数据
    public List<YndpFkdcWzbz> findWzbzListByJgId(String jgId) {
        return yndpFkdcWzbzRepository.findWzbzListByJgId(jgId);
    }
}
