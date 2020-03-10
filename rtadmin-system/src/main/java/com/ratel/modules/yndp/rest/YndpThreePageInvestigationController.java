package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpThreePageInvestigation;
import com.ratel.modules.yndp.service.YndpThreePageInvestigationService;
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
 * 固定检查点排查
 * @author GXP
 * @date 2020/2/27 17:16
 */
@Api(tags = "第三屏：固定检查点排查 ")
@RestController
@RequestMapping("/api/yndp/Investigation")
public class YndpThreePageInvestigationController {

    @Autowired
    YndpThreePageInvestigationService YndpThreePageInvestigationService;

    @ApiOperation("根据日期查询社区/村人员核查和信息采集 ")
    @GetMapping(value = "/getYndpThreePageInvestigation")
    public Result getYndpThreePageInvestigation(@RequestParam String date, HttpServletRequest request, HttpServletResponse response) {

        //1. 根据日期查询三类重点目标人群核查
        YndpThreePageInvestigation yndpThreePageInvestigation = YndpThreePageInvestigationService.getYndpThreePageInvestigation(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpThreePageInvestigation);
        result.setMessage("成功");
        return result;
    }

}
