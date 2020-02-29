package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFkbsJg;
import com.ratel.modules.yndp.domain.YndpFkdcMap;
import com.ratel.modules.yndp.domain.YndpFkdcMapSj;
import com.ratel.modules.yndp.domain.YndpFkdcSj;
import com.ratel.modules.yndp.service.YndpFkdcMapService;
import com.ratel.modules.yndp.service.YndpFkdcMapSjService;
import com.ratel.modules.yndp.service.YndpFkdcSjService;
import com.ratel.modules.yndp.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * 中间地图
 * @author DDXS
 * @date 2020/2/28 9:06
 */
@Api(tags = "中间地图")
@RestController
@RequestMapping("/api/yndp/map")
public class YndpFkdcMapController {

    @Autowired
    YndpFkdcMapSjService yndpFkdcMapSjService;
    @Autowired
    YndpFkdcMapService yndpFkdcMapService;
    @Autowired
    YndpFkdcSjService yndpFkdcSjService;

    @ApiOperation("根据机构ID查询出地图事件")
    @GetMapping(value = "/getMapSjList")
    public Result getMapSjList(@RequestParam String jgId, HttpServletRequest request, HttpServletResponse response) {
        List<YndpFkdcSj>  yndpFkdcSjList = yndpFkdcSjService.getMapSjList(jgId);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFkdcSjList);
        result.setMessage("成功");
        return result;
    }

    @ApiOperation("根据机构ID查询出地图汇总数据")
    @GetMapping(value = "/getMapHzsjList")
    public Result getMapHzsjList(@RequestParam String jgId, HttpServletRequest request, HttpServletResponse response) {
        YndpFkdcMapSj  yndpFkdcMapSj = yndpFkdcMapSjService.getMapHz(jgId);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFkdcMapSj);
        result.setMessage("成功");
        return result;
    }

    @ApiOperation("根据机构ID和确诊类型查询地图数据")
    @GetMapping(value = "/getMapList")
    public Result getMapList(@RequestParam(value = "jgId") String jgId, @RequestParam(value = "qzlx") String qzlx, HttpServletRequest request, HttpServletResponse response) {
        List<Map>  mapList = yndpFkdcMapService.getMapList(jgId,qzlx);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(mapList);
        result.setMessage("成功");
        return result;
    }

}
