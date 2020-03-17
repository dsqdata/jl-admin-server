package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpOneLeadingGroup;
import com.ratel.modules.yndp.domain.YndpThreePageBroadcast;
import com.ratel.modules.yndp.service.YndpOneLeadingGroupService;
import com.ratel.modules.yndp.service.YndpThreePageBroadcastService;
import com.ratel.modules.yndp.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 第一屏-应对疫情工作领导小组/指挥部Controller
 * @author DDXS
 * @date 2020/3/17 16:18
 */
@Api(tags = "第一屏-应对疫情工作领导小组/指挥部")
@RestController
@RequestMapping("/api/yndp/leadingGroup")
public class YndpOneLeadingGroupController {

    @Autowired
    YndpOneLeadingGroupService yndpOneLeadingGroupService;

    @ApiOperation("应对疫情工作领导小组和指挥部数据查询")
    @GetMapping(value = "/getLeadingGroup")
    public Result getLeadingGroup( HttpServletRequest request, HttpServletResponse response) {

        Map map = new HashMap<>();
        // 1.查询应对疫情工作领导小组数据
        List<YndpOneLeadingGroup> yqgzldxzList = yndpOneLeadingGroupService.findYqgzldxzOrZhbByType("1");
        // 2.查询指挥部数据
        List<YndpOneLeadingGroup> zhbList = yndpOneLeadingGroupService.findYqgzldxzOrZhbByType("2");

        map.put("yqgzldxzList",yqgzldxzList);
        map.put("zhbList",zhbList);

        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(map);
        result.setMessage("成功");
        return result;
    }

}
