package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFkbsJg;
import com.ratel.modules.yndp.domain.YndpFkdcWghpcLflk;
import com.ratel.modules.yndp.repository.YndpFkbsJgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public YndpFkbsJg getSjJg(String jgId) {
        if(jgId.equals("0")){//说明没有上机构
          return null;
        }
        // 1.查询出当前机构
        YndpFkbsJg jg = yndpFkbsJgRepository.getJg(jgId);
        String parentid = jg.getParentid();
        // 2.查询出上级机构
        YndpFkbsJg sjjg = yndpFkbsJgRepository.getJg(parentid);
        return sjjg;
    }

    // 根据机构ID查询出当前机构
    public YndpFkbsJg getJg(String jgId) {
       return yndpFkbsJgRepository.getJg(jgId);
    }

    // 根据机构ID查询出下级机构列表
    public List<YndpFkbsJg> getXjJgList(String jgId) {
        return yndpFkbsJgRepository.getXjJgList(jgId);
    }

     // 查询出一屏页面所有机构
    public List<YndpFkbsJg> getAllJg() {
        return yndpFkbsJgRepository.getAllJg();
    }
}
