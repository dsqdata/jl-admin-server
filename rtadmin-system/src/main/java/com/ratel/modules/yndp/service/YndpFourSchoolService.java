package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFourSchool;
import com.ratel.modules.yndp.domain.YndpFourSchoolMsg;
import com.ratel.modules.yndp.domain.YndpThreePageSchool;
import com.ratel.modules.yndp.repository.YndpFourSchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

/**
 * 学校复工情况
 * @author xjl
 * @date 2020/3/9
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFourSchoolService extends BaseService<YndpFourSchool, String> {

    @Autowired
    private YndpFourSchoolRepository yndpFourSchoolRepository;

    public List<YndpFourSchool> getXxjw(String name) {
        return yndpFourSchoolRepository.getXxjw(name);
    }


    public String getXxzs() {
        return yndpFourSchoolRepository.getXxzs();
    }

    public List<Map> getXxtl() {
        return yndpFourSchoolRepository.getXxtl();
    }

    public List<String> getXxfls(String date){
            return yndpFourSchoolRepository.getXxfls(date);
    }

    public List<Map> getXxtjs21(String date,String name){
        return yndpFourSchoolRepository.getXxtjs21(date,name);
    }
    public List<Map> getXxtjs25(String date,String name){
        return yndpFourSchoolRepository.getXxtjs25(date,name);
    }
    public List<Map> getXxtjs26(String date,String name){
        return yndpFourSchoolRepository.getXxtjs26(date,name);
    }
    public List<Map> getXxtjs27(String date,String name){
        return yndpFourSchoolRepository.getXxtjs27(date,name);
    }
}
