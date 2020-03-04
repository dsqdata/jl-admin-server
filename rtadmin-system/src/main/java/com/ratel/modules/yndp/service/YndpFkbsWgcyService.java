package com.ratel.modules.yndp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFkbsJg;
import com.ratel.modules.yndp.domain.YndpFkbsWg;
import com.ratel.modules.yndp.domain.YndpFkbsWgcy;
import com.ratel.modules.yndp.mapper.YndpFkbsWgcyMapper;
import com.ratel.modules.yndp.repository.YndpFkbsWgcyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 防控部署-网格成员service
 * @author DDXS
 * @date 2020/2/28 12:28
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFkbsWgcyService extends BaseService<YndpFkbsWgcy, String> {

    @Autowired
    YndpFkbsWgcyRepository yndpFkbsWgcyRepository;
    @Autowired
    YndpFkbsWgcyMapper yndpFkbsWgcyMapper;

    // 根据网格ID查询出网格成员列表
    public PageInfo<YndpFkbsWgcy> getWgcyList(String wgId, PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNumber();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<YndpFkbsWgcy> yndpFkbsWgcyList = yndpFkbsWgcyMapper.getWgcyList(wgId);
        return new PageInfo<YndpFkbsWgcy>(yndpFkbsWgcyList);

    }
}
