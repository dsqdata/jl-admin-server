package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFkbsJg;
import com.ratel.modules.yndp.util.DateUtils;
import com.ratel.modules.yndp.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 获取当前时间Controller
 * @author DDXS
 * @date 2020/3/9 17:31
 */
@Api(tags = "第三屏：获取当前时间")
@RestController
@RequestMapping("/api/yndp/time")
public class YndpThreePageCurrentTimeController {

    @ApiOperation("第三屏：获取当前时间")
    @GetMapping(value = "/getBeforeDay")
    public Result getBeforeDay(HttpServletRequest request, HttpServletResponse response) {
       // 1.获取当前日期前一天
//        String beforeDay = DateUtils.getBeforeDay();
        String beforeDay = DateUtils.getBeforeYesterday();
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(beforeDay); //格式：2020-03-08
        result.setMessage("成功");
        return result;
    }

}
