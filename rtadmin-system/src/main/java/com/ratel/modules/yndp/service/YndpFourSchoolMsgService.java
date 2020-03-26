package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFourSchoolMsg;
import com.ratel.modules.yndp.repository.YndpFourSchoolMsgRepository;
import com.ratel.modules.yndp.mapper.YndpFourSchoolMsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 学校疫情信息Service
 * @author GXP
 * @date 2020/2/27 17:22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFourSchoolMsgService extends BaseService<YndpFourSchoolMsg, String> {

    @Autowired
    YndpFourSchoolMsgMapper YndpFourSchoolMsgMapper;

    //1.有学校ID，根据日期和学校ID查询学校疫情信息
    /*public YndpFourSchoolMsg getYndpFourSchoolMsg(String date,String school_id,int type) {
        return YndpFourSchoolMsgRepository.getYndpFourSchoolMsg(date,school_id,type);
    }*/

    //根据日期和学校ID和人员类型查询学校疫情信息Echart图
    public List<YndpFourSchoolMsg> getYndpFourSchoolMsgList(String date,String school_id,int type) {
        System.out.println(school_id);
        System.out.println(school_id.length());
        if(3==type ){
            if(school_id != null && school_id.length() != 0){
                return YndpFourSchoolMsgMapper.getAllPeopleMsgList(date,school_id);
            }else{
                return YndpFourSchoolMsgMapper.getAllMsgList(date);
            }

        }else if(school_id != null && school_id.length() != 0){
            System.out.println(111);
            return YndpFourSchoolMsgMapper.getYndpFourSchoolMsgList(date,school_id,type);
        }else {
            System.out.println(222);
            return YndpFourSchoolMsgMapper.getAllSchoolMsgList(date,type);
        }

    }
}
