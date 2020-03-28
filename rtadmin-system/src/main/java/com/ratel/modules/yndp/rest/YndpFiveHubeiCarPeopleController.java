package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFiveHubeiCarPeople;
import com.ratel.modules.yndp.service.YndpFiveHubeiCarPeopleService;
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

/**
 * 湖北入昆车辆人员
 * @author GXP
 * @date 2020/2/27 17:16
 */
@Api(tags = "第五屏：湖北入昆车辆人员")
@RestController
@RequestMapping("/api/yndp/HubeiCarPeople")
public class YndpFiveHubeiCarPeopleController {

    @Autowired
    YndpFiveHubeiCarPeopleService YndpFiveHubeiCarPeopleService;

    @ApiOperation("根据日期查询湖北入昆车辆人员")
    @GetMapping(value = "/getYndpFiveHubeiCarPeople")
    public Result getYndpFiveHubeiCarPeople(@RequestParam String date, HttpServletRequest request, HttpServletResponse response) {

        YndpFiveHubeiCarPeople YndpFiveHubeiCarPeople = YndpFiveHubeiCarPeopleService.getYndpFiveHubeiCarPeople(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(YndpFiveHubeiCarPeople);
        result.setMessage("成功");
        return result;
    }

}
