package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpThreePageSchool;
import com.ratel.modules.yndp.repository.YndpXxfgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 学校复工情况
 * @author xjl
 * @date 2020/3/9
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpXxfgService extends BaseService<YndpThreePageSchool, String> {

    @Autowired
    private YndpXxfgRepository yndpXxfgRepository;

    public YndpThreePageSchool getXxfgList(String date) {
        return yndpXxfgRepository.getXxfgList(date);
    }
}
