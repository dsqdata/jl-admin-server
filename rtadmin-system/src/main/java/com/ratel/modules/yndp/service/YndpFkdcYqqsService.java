package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFkdcYqqs;
import com.ratel.modules.yndp.repository.YndpFkdcYqqsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFkdcYqqsService extends BaseService<YndpFkdcYqqs, String> {

    @Autowired
    private YndpFkdcYqqsRepository yndpFkdcYqqsRepository;

    public Object getYqqsChartData(YndpFkdcYqqs yndpFkdcYqqs) {
        Map<String, Object> map = new HashMap<>();
        LocalDate localDate = LocalDate.now();
        List<YndpFkdcYqqs> list;
        if("ALL".equals(yndpFkdcYqqs.getRowCount())){
            list = yndpFkdcYqqsRepository.findYqqs(yndpFkdcYqqs.getYqlx(),yndpFkdcYqqs.getJgid());
        }else {
            list = yndpFkdcYqqsRepository.findYqqs(localDate.minusDays(Long.parseLong(yndpFkdcYqqs.getRowCount())).toString(), localDate.plusDays(0).toString(), yndpFkdcYqqs.getYqlx(),yndpFkdcYqqs.getJgid());
        }
        map.put("weekDays", list.stream().map(YndpFkdcYqqs::getRq).collect(Collectors.toList()));
        map.put("yqmc", list.stream().map(YndpFkdcYqqs::getYqmc).collect(Collectors.toList()));
        map.put("yqsl", list.stream().map(YndpFkdcYqqs::getYqsl).collect(Collectors.toList()));
        return map;
    }
}
