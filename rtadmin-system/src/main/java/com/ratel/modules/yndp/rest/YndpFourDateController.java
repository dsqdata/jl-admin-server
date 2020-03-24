package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFourDate;
import com.ratel.modules.yndp.service.YndpFourDateService;
import com.ratel.modules.yndp.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 校园疫情防控-数据更新时间
 * @author GXP
 * @date 2020/2/27 17:16
 */
@Api(tags = "第四屏：校园疫情防控-数据更新时间 ")
@RestController
@RequestMapping("/api/yndp/FourDate")
public class YndpFourDateController {

    @Autowired
    YndpFourDateService YndpFourDateService;

    @ApiOperation("查询数据更新时间 ")
    @GetMapping(value = "/getYndpFourDate")
    public Result getYndpFourDate(HttpServletRequest request, HttpServletResponse response) {

        YndpFourDate YndpFourDate = YndpFourDateService.getYndpFourDate();
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(YndpFourDate);
        result.setMessage("成功");
        return result;
    }

}
