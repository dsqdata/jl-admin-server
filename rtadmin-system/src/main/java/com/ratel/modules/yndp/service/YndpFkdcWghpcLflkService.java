package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFkdcWghpcLflk;
import com.ratel.modules.yndp.domain.YndpFkdcWzbz;
import com.ratel.modules.yndp.repository.YndpFkdcFkxcRepository;
import com.ratel.modules.yndp.repository.YndpFkdcWghpcLflkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 网格化排查及联防联控Service
 * @author DDXS
 * @date 2020/2/27 17:22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFkdcWghpcLflkService extends BaseService<YndpFkdcWghpcLflk, String> {

    @Autowired
    private YndpFkdcWghpcLflkRepository yndpFkdcWghpcLflkRepository;

    public List<YndpFkdcWghpcLflk> getPcjlflkList(String jgId) {
        return yndpFkdcWghpcLflkRepository.getPcjlflkList(jgId);
    }

    public List<YndpFkdcWghpcLflk> getPcjlflkListAll(String jgId) {
        return yndpFkdcWghpcLflkRepository.getPcjlflkListAll(jgId);
    }
}
