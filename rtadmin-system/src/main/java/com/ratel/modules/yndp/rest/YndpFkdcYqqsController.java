package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFkdcYqqs;
import com.ratel.modules.yndp.service.YndpFkdcYqqsService;
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
@RequestMapping("/api/yndp/yqqs")
@Api(tags = "第二屏：疫情趋势图管理")
public class YndpFkdcYqqsController {

    @Autowired
    private YndpFkdcYqqsService yndpFkdcYqqsService;

    @GetMapping(value = "/getYqqsChartData")
    @ApiOperation("疫情趋势图")
    public Result getYqqsChartData(YndpFkdcYqqs yndpFkdcYqqs) {
//        return new ResponseEntity<>(yndpFkdcYqqsService.getYqqsChartData(yndpFkdcYqqs), HttpStatus.OK);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFkdcYqqsService.getYqqsChartData(yndpFkdcYqqs));
        result.setMessage("成功");
        return result;
    }
}
