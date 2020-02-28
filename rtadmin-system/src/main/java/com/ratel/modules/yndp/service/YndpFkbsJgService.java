package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFkbsJg;
import com.ratel.modules.yndp.domain.YndpFkdcWghpcLflk;
import com.ratel.modules.yndp.repository.YndpFkbsJgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 防控部署-机构service
 * @author DDXS
 * @date 2020/2/28 12:28
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFkbsJgService extends BaseService<YndpFkbsJg, String> {

    @Autowired
    YndpFkbsJgRepository yndpFkbsJgRepository;

    // 根据机构ID查询出上级机构
    public YndpFkbsJg getSjjg(String jgId) {
        // 1.查询出当前机构的父ID
        YndpFkbsJg jg = yndpFkbsJgRepository.getjg(jgId);
        String parentid = jg.getParentid();
        if(parentid.equals("0")){//说明是最高层机构
         // 如果是最高层机构返回空
            return null;
        }else{
            // 2.查询出上级机构
            YndpFkbsJg sjjg = yndpFkbsJgRepository.getjg(parentid);
            return sjjg;
        }
    }

    // 根据机构ID查询出当前机构
    public YndpFkbsJg getjg(String jgId) {
       return yndpFkbsJgRepository.getjg(jgId);
    }


}
