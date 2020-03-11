package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpSjgxsj;
import com.ratel.modules.yndp.domain.YndpThreePageSituation;
import com.ratel.modules.yndp.repository.YndpThreePageSituationReposiitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 第三屏  当日疫情动态
 * @author DDXS
 * @date 2020/3/9 14:46
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpThreePageSituationService  extends BaseService<YndpThreePageSituation, String> {

    @Autowired
    YndpThreePageSituationReposiitory yndpThreePageSituationReposiitory;

    // 根据时间查询当日疫情动态
    public List<YndpThreePageSituation> getSituation(String date) {
     return yndpThreePageSituationReposiitory.getSituation(date);
    }

    //发热门诊接触弹出图表List
    public List<YndpThreePageSituation> getReceive(String date) {
        return yndpThreePageSituationReposiitory.getReceive(date);
    }

}
