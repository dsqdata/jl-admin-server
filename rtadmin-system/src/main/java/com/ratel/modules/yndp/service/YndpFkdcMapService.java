package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpFkbsJg;
import com.ratel.modules.yndp.domain.YndpFkdcMap;
import com.ratel.modules.yndp.domain.YndpFkdcMapSj;
import com.ratel.modules.yndp.repository.YndpFkdcMapRepository;
import com.ratel.modules.yndp.util.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 中间地图service
 * @author DDXS
 * @date 2020/2/28 9:09
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpFkdcMapService extends BaseService<YndpFkdcMap, String> {

    @Autowired
    YndpFkdcMapRepository yndpFkdcMapRepository;

    // 根据机构ID和确诊类型查询地图数据
    public List<Map> getMapList(String jgId, String qzlx) {
       return yndpFkdcMapRepository.getMapList(jgId,qzlx);
    }

}
