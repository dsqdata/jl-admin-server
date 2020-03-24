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

    public YndpFourSchool getXxzs() {
        return yndpFourSchoolRepository.getXxzs();
    }

    public List<YndpFourSchool> getXxtl() {
        return yndpFourSchoolRepository.getXxtl();
    }

    public List<String> getXxfls(String date){
            return yndpFourSchoolRepository.getXxfls(date);
    }

    public List<YndpFourSchoolMsg> getXxtjs21(String date){
        return yndpFourSchoolRepository.getXxtjs21(date);
    }
    public List<YndpFourSchoolMsg> getXxtjs25(String date){
        return yndpFourSchoolRepository.getXxtjs25(date);
    }
    public List<YndpFourSchoolMsg> getXxtjs26(String date){
        return yndpFourSchoolRepository.getXxtjs26(date);
    }
    public List<YndpFourSchoolMsg> getXxtjs27(String date){
        return yndpFourSchoolRepository.getXxtjs27(date);
    }
}
