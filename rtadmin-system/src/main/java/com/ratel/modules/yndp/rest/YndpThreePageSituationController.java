package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFkbsJg;
import com.ratel.modules.yndp.domain.YndpThreePageSituation;
import com.ratel.modules.yndp.service.YndpThreePageSituationService;
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
 * 第三屏  当日疫情动态
 * @author DDXS
 * @date 2020/3/9 14:41
 */
@Api(tags = "第三屏：当日疫情动态")
@RestController
@RequestMapping("/api/yndp/situation")
public class YndpThreePageSituationController {

    @Autowired
    YndpThreePageSituationService yndpThreePageSituationService;


    @ApiOperation("第三屏：根据时间查询当日疫情动态")
    @GetMapping(value = "/getSituation")
    public Result getSituation(@RequestParam String date, HttpServletRequest request, HttpServletResponse response) {
        // 根据时间查询当日疫情动态
        List<YndpThreePageSituation> yndpThreePageSituationList = yndpThreePageSituationService.getSituation(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpThreePageSituationList);
        result.setMessage("成功");
        return result;
    }

    @ApiOperation("第三屏：发热门诊接触弹出图表接口")
    @GetMapping(value = "/getReceive")
    public Result getReceive(@RequestParam String date, HttpServletRequest request, HttpServletResponse response) {
        // 发热门诊接触弹出图表List
        List<YndpThreePageSituation> yndpThreePageReceiveList = yndpThreePageSituationService.getReceive(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpThreePageReceiveList);
        result.setMessage("成功");
        return result;
    }

}
