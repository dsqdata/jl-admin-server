package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpThreePageBroadcast;
import com.ratel.modules.yndp.domain.YndpThreePageSituation;
import com.ratel.modules.yndp.service.YndpThreePageBroadcastService;
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
 * 第三屏：其他疫情信息播报
 * @author DDXS
 * @date 2020/3/9 14:44
 */
@Api(tags = "第三屏：其他疫情信息播报")
@RestController
@RequestMapping("/api/yndp/broadcast")
public class YndpThreePageBroadcastController {

    @Autowired
    YndpThreePageBroadcastService yndpThreePageBroadcastService;

    @ApiOperation("第三屏：根据时间查询其他疫情信息播报")
    @GetMapping(value = "/getBroadcast")
    public Result getBroadcast(@RequestParam String date, HttpServletRequest request, HttpServletResponse response) {

        // 根据时间查询当日疫情动态
        List<YndpThreePageBroadcast> yndpThreePageBroadcastList = yndpThreePageBroadcastService.getBroadcast(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpThreePageBroadcastList);
        result.setMessage("成功");
        return result;
    }
}
