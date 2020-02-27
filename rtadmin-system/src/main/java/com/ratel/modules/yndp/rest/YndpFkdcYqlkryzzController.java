package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFkdcYqqs;
import com.ratel.modules.yndp.service.YndpFkdcYqqsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/yqlkryzz")
@Api(tags = "疫区来昆人员追踪管理")
public class YndpFkdcYqlkryzzController {

    @Autowired
    private YndpFkdcYqqsService yndpFkdcYqqsService;

    @GetMapping(value = "/getYqlkryzzData")
    @ApiOperation("疫区来昆人员追踪数据")
    public ResponseEntity<Object> getYqlkryzzData(YndpFkdcYqqs yndpFkdcYqqs) {
        return new ResponseEntity<>(yndpFkdcYqqsService.getYqqsChartData(yndpFkdcYqqs), HttpStatus.OK);
    }

    @GetMapping(value = "/getDayData")
    @ApiOperation("查询每日数据")
    public ResponseEntity<Object> getDayData(YndpFkdcYqqs yndpFkdcYqqs) {
        return new ResponseEntity<>(yndpFkdcYqqsService.getYqqsChartData(yndpFkdcYqqs), HttpStatus.OK);
    }
}