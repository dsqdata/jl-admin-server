package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFkdcYqlkryzz;
import com.ratel.modules.yndp.service.YndpFkdcYqlkryzzService;
import com.ratel.modules.yndp.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/yndp/yqlkryzz")
@Api(tags = "第二屏：疫区来昆人员追踪管理")
public class YndpFkdcYqlkryzzController {

    @Autowired
    private YndpFkdcYqlkryzzService yndpFkdcYqlkryzzService;

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
}
