package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFkdcZdrymp;
import com.ratel.modules.yndp.repository.YndpFkdcZdrympRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFkdcZdrympService extends BaseService<YndpFkdcZdrymp, String> {

    @Autowired
    private YndpFkdcZdrympRepository yndpFkdcZdrympRepository;

    public Object getZdrympData(YndpFkdcZdrymp yndpFkdcZdrymp) {
        Map<String, Object> map = new HashMap<>();
        List<YndpFkdcZdrymp> list = yndpFkdcZdrympRepository.findZdrymp(yndpFkdcZdrymp.getZdrylx(),yndpFkdcZdrymp.getJgid(),yndpFkdcZdrymp.getField4());
//        map.put("zdrymc", list.stream().map(YndpFkdcZdrymp::getZdrymc).collect(Collectors.toList()));
//        map.put("zdryrs", list.stream().map(YndpFkdcZdrymp::getZdryrs).collect(Collectors.toList()));
//        map.put("zdryrszb", list.stream().map(YndpFkdcZdrymp::getZdryrszb).collect(Collectors.toList()));
//        map.put("zdryxzrs", list.stream().map(YndpFkdcZdrymp::getZdryxzrs).collect(Collectors.toList()));
        return list;
    }

    public String getMaxDay(YndpFkdcZdrymp yndpFkdcZdrymp) {
        return yndpFkdcZdrympRepository.getMaxDay(yndpFkdcZdrymp.getZdrylx(),yndpFkdcZdrymp.getJgid());
    }

    public Object getZdrympDataList(YndpFkdcZdrymp yndpFkdcZdrymp) {
        Map<String, Object> map = new HashMap<>();
        // 重点人员类型（1 特殊人群 2 入住留验点人员 3登记在册 4公安检查点排查人员）
        List<YndpFkdcZdrymp> tsrqList = yndpFkdcZdrympRepository.findZdrympList("1",yndpFkdcZdrymp.getJgid());
        List<YndpFkdcZdrymp> rzlydryList = yndpFkdcZdrympRepository.findZdrympList("2",yndpFkdcZdrymp.getJgid());
        List<YndpFkdcZdrymp> djzcList = yndpFkdcZdrympRepository.findZdrympList("3",yndpFkdcZdrymp.getJgid());
        List<YndpFkdcZdrymp> gajcdpcryList = yndpFkdcZdrympRepository.findZdrympList("4",yndpFkdcZdrymp.getJgid());
        map.put("tsrqList",tsrqList);
        map.put("rzlydryList",rzlydryList);
        map.put("djzcList",djzcList);
        map.put("gajcdpcryList",gajcdpcryList);
        return map;
    }
}
