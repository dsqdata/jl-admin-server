package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpThreePageRework;
import com.ratel.modules.yndp.service.YndpQyfgfcService;
import com.ratel.modules.yndp.service.YndpXxfgService;
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
import java.util.List;

/**
 * 企业复工复产情况
 * @author xjl
 * @date 2020/3/9
 */
@Api(tags = "第三屏：企业复工复产情况")
@RestController
@RequestMapping("/api/yndp/qyfgfc")
public class YndpQyfgfcController {
    
    @Autowired
    YndpQyfgfcService yndpQyfgfcService;

    @ApiOperation("根据日期查询出企业复工复产情况")
    @GetMapping(value = "/getQyfgfcList")
    public Result getXxfgList(@RequestParam String date,HttpServletRequest request, HttpServletResponse response) {

        // 1. 根据所选择的机构ID查询出列表
        List<YndpThreePageRework> yndpQyfgfcList = yndpQyfgfcService.getQyfgfcList(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpQyfgfcList);
        result.setMessage("成功");
        return result;
    }


    @ApiOperation("根据日期查询出企业复工复产情况选定日期之前的Echart列表")
    @GetMapping(value = "/getQyfgfcEchartList")
    public Result getQyfgfcEchartList(@RequestParam String date,HttpServletRequest request, HttpServletResponse response) {

        // 1. 根据所选择的机构ID查询出列表
        List<YndpThreePageRework> yndpQyfgfcEchartList = yndpQyfgfcService.getQyfgfcEchartList(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpQyfgfcEchartList);
        result.setMessage("成功");
        return result;
    }
}
