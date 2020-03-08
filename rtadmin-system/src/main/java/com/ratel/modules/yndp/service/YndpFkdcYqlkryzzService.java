package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFkdcYqlkryzz;
import com.ratel.modules.yndp.repository.YndpFkdcYqlkryzzRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFkdcYqlkryzzService extends BaseService<YndpFkdcYqlkryzz, String> {

    @Autowired
    private YndpFkdcYqlkryzzRepository yndpFkdcYqlkryzzRepository;

    public Object getYqlkryzzData(YndpFkdcYqlkryzz yndpFkdcYqlkryzz) {
        Map<String, Object> map = new HashMap<>();
        LocalDate localDate = LocalDate.now();
        List<YndpFkdcYqlkryzz> list;
        if("ALL".equals(yndpFkdcYqlkryzz.getSevenDays())){
            list = yndpFkdcYqlkryzzRepository.findYqlkryzz(localDate.minusDays(7).toString(), localDate.plusDays(0).toString(), yndpFkdcYqlkryzz.getJgid());
        }else {
            list = yndpFkdcYqlkryzzRepository.findYqlkryzz(yndpFkdcYqlkryzz.getStartDate(), yndpFkdcYqlkryzz.getEndDate(),yndpFkdcYqlkryzz.getJgid());
        }
        map.put("rylx", list.stream().map(YndpFkdcYqlkryzz::getRylx).collect(Collectors.toList()));
        map.put("rysl", list.stream().map(YndpFkdcYqlkryzz::getRysl).collect(Collectors.toList()));
        return map;
    }

    public Object getDayData(YndpFkdcYqlkryzz yndpFkdcYqlkryzz) {
        Map<String, Object> map = new HashMap<>();
        List<YndpFkdcYqlkryzz> list;

        list = yndpFkdcYqlkryzzRepository.findDayData(yndpFkdcYqlkryzz.getStartDate(),yndpFkdcYqlkryzz.getEndDate(), yndpFkdcYqlkryzz.getJgid());

        map.put("weekDays", list.stream().map(YndpFkdcYqlkryzz::getRq).collect(Collectors.toList()));
        map.put("rysl", list.stream().map(YndpFkdcYqlkryzz::getRysl).collect(Collectors.toList()));
        return map;
    }

    public List<YndpFkdcYqlkryzz> getSameDay(String data,String jgId) {
        return yndpFkdcYqlkryzzRepository.getSameDay(data,jgId);
    }

    public String getMaxDay() {
        return yndpFkdcYqlkryzzRepository.getMaxDay();
    }

}
