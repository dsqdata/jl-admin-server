package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpThreePageBroadcast;
import com.ratel.modules.yndp.repository.YndpThreePageBroadcastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 第三屏：其他疫情信息播报
 * @author DDXS
 * @date 2020/3/9 14:46
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpThreePageBroadcastService extends BaseService<YndpThreePageBroadcast, String> {

    @Autowired
    YndpThreePageBroadcastRepository yndpThreePageBroadcastRepository;
    // 根据时间查询其他疫情信息播报
    public List<YndpThreePageBroadcast> getBroadcast(String date) {
        return yndpThreePageBroadcastRepository.getBroadcast(date);
    }
}
