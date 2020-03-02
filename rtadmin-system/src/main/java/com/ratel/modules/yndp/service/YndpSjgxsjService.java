package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFkbsJg;
import com.ratel.modules.yndp.domain.YndpSjgxsj;
import com.ratel.modules.yndp.repository.YndpSjgxsjRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 数据时间更新service
 * @author DDXS
 * @date 2020/3/2 16:20
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpSjgxsjService  extends BaseService<YndpSjgxsj, String> {

    @Autowired
    YndpSjgxsjRepository yndpSjgxsjRepository;
    //查询出数据更新时间
    public YndpSjgxsj getGxsj() {
        return yndpSjgxsjRepository.getGxsj();
    }
}
