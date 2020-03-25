package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFkdcYqlkryzz;
import com.ratel.modules.yndp.domain.YndpSjgxsj;
import com.ratel.modules.yndp.service.YndpFkdcYqlkryzzService;
import com.ratel.modules.yndp.service.YndpSjgxsjService;
import com.ratel.modules.yndp.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/api/yndp/yqlkryzz")
@Api(tags = "第二屏：疫区来昆人员追踪管理")
public class YndpFkdcYqlkryzzController {

    @Autowired
    private YndpFkdcYqlkryzzService yndpFkdcYqlkryzzService;

    @Autowired
    YndpSjgxsjService yndpSjgxsjService;

    @GetMapping(value = "/getYqlkryzzData")
    @ApiOperation("疫区来昆人员追踪数据")
    public Result getYqlkryzzData(YndpFkdcYqlkryzz yndpFkdcYqlkryzz) {
//        return new ResponseEntity<>(yndpFkdcYqlkryzzService.getYqlkryzzData(yndpFkdcYqlkryzz), HttpStatus.OK);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFkdcYqlkryzzService.getYqlkryzzData(yndpFkdcYqlkryzz));
        result.setMessage("成功");
        return result;
    }

    @GetMapping(value = "/getDayData")
    @ApiOperation("查询每日数据")
    public Result getDayData(YndpFkdcYqlkryzz yndpFkdcYqlkryzz) {
//        return new ResponseEntity<>(yndpFkdcYqlkryzzService.getDayData(yndpFkdcYqlkryzz), HttpStatus.OK);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFkdcYqlkryzzService.getDayData(yndpFkdcYqlkryzz));
        result.setMessage("成功");
        return result;
    }

    @GetMapping(value = "/getSameDay")
    @ApiOperation("查询当日日数据")
    public List<YndpFkdcYqlkryzz> getSameDay(@RequestParam String jgId, HttpServletRequest request, HttpServletResponse response) {

        //1. 根据所选择的机构ID查询出列表
        String rq = yndpFkdcYqlkryzzService.getMaxDay();


        List<YndpFkdcYqlkryzz> yndpFkdcYqlkryzzList = yndpFkdcYqlkryzzService.getSameDay(rq,jgId);
        return yndpFkdcYqlkryzzList;
    }

    @GetMapping(value = "/getChartData")
    @ApiOperation("查询折线图数据")
    public Result getChartData(@RequestParam String jgId) {
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFkdcYqlkryzzService.getChartData(jgId));
        result.setMessage("成功");
        return result;
    }


    @GetMapping(value = "/getChartDataList")
    @ApiOperation("查询中下疫区来昆人员追踪")
    public Result getChartDataList(@RequestParam String jgId) {
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFkdcYqlkryzzService.getChartDataList(jgId));
        result.setMessage("成功");
        return result;
    }


}
