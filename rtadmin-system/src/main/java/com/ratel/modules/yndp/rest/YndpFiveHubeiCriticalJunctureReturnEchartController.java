package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFiveHubeiCriticalJunctureReturnEchart;
import com.ratel.modules.yndp.service.YndpFiveHubeiCriticalJunctureReturnEchartService;
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
 * 湖北返回情况echart图表
 * @author GXP
 * @date 2020/2/27 17:16
 */
@Api(tags = "第五屏：湖北返回情况echart图表 ")
@RestController
@RequestMapping("/api/yndp/JunctureReturn")
public class YndpFiveHubeiCriticalJunctureReturnEchartController {

    @Autowired
    YndpFiveHubeiCriticalJunctureReturnEchartService YndpFiveHubeiCriticalJunctureReturnEchartService;

    @ApiOperation("根据日期查询湖北返回情况echart图表 ")
    @GetMapping(value = "/getYndpFiveHubeiCriticalJunctureReturnEchartList")
    public Result getYndpFiveHubeiCriticalJunctureReturnEchartList(@RequestParam String date, HttpServletRequest request, HttpServletResponse response) {

        List<YndpFiveHubeiCriticalJunctureReturnEchart> YndpFiveHubeiCriticalJunctureReturnEchartList = YndpFiveHubeiCriticalJunctureReturnEchartService.getYndpFiveHubeiCriticalJunctureReturnEchartList(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(YndpFiveHubeiCriticalJunctureReturnEchartList);
        result.setMessage("成功");
        return result;
    }

}