package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpThreePageRework;
import com.ratel.modules.yndp.domain.YndpThreePageSchool;
import com.ratel.modules.yndp.repository.YndpQyfgfcRepository;
import com.ratel.modules.yndp.repository.YndpXxfgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 企业复工复产情况
 * @author xjl
 * @date 2020/3/9
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpQyfgfcService extends BaseService<YndpThreePageRework, String> {

    @Autowired
    private YndpQyfgfcRepository yndpQyfgfcRepository;

    public List<YndpThreePageRework> getQyfgfcList(String date) {
        return yndpQyfgfcRepository.getQyfgfcList(date);
    }

    public List<YndpThreePageRework> getQyfgfcEchartList(String date) {
        return yndpQyfgfcRepository.getQyfgfcEchartList(date);
    }
}
