package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpThreePageCheck;
import com.ratel.modules.yndp.service.YndpThreePageCheckService;
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
 * 三类重点目标人群核查
 * @author GXP
 * @date 2020/2/27 17:16
 */
@Api(tags = "第三屏：三类重点目标人群核查")
@RestController
@RequestMapping("/api/yndp/check")
public class YndpThreePageCheckController {

    @Autowired
    YndpThreePageCheckService YndpThreePageCheckService;

    @ApiOperation("根据日期查询三类重点目标人群核查")
    @GetMapping(value = "/getYndpThreePageCheckList")
    public Result getYndpThreePageCheckList(@RequestParam String date, HttpServletRequest request, HttpServletResponse response) {

        //1. 根据日期查询三类重点目标人群核查
        List<YndpThreePageCheck> YndpThreePageCheckList = YndpThreePageCheckService.getYndpThreePageCheckList(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(YndpThreePageCheckList);
        result.setMessage("成功");
        return result;
    }

}
