package com.ratel.modules.yndp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFkbsJg;
import com.ratel.modules.yndp.domain.YndpFkbsWg;
import com.ratel.modules.yndp.mapper.YndpFkbsWgMapper;
import com.ratel.modules.yndp.repository.YndpFkbsWgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
    @Autowired
    YndpFkbsWgMapper yndpFkbsWgMapper;

    // 根据机构ID查询出所有网格
    public PageInfo<YndpFkbsWg> getWgList(String jgId, PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNumber();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<YndpFkbsWg> yndpFkbsWgList = yndpFkbsWgMapper.getWgList(jgId);
        return new PageInfo<YndpFkbsWg>(yndpFkbsWgList);
    }
}
