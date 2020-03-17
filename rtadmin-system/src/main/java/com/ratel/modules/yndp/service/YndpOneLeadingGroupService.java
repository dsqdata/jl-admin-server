package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpOneLeadingGroup;
import com.ratel.modules.yndp.domain.YndpThreePageSupervisor;
import com.ratel.modules.yndp.repository.YndpOneLeadingGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 第一屏-应对疫情工作领导小组/指挥部Service
 * @author DDXS
 * @date 2020/3/17 16:00
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpOneLeadingGroupService  extends BaseService<YndpOneLeadingGroup, String> {

    @Autowired
    YndpOneLeadingGroupRepository yndpOneLeadingGroupRepository;

    // 根据类型查询应对疫情工作领导小组数据和指挥部数据
    public List<YndpOneLeadingGroup> findYqgzldxzOrZhbByType(String type) {
       return yndpOneLeadingGroupRepository.findYqgzldxzOrZhbByType(type);
    }

}
