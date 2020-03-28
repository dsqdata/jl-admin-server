package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFiveHubeiPeopleEchart;
import com.ratel.modules.yndp.service.YndpFiveHubeiPeopleEchartService;
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
 * 湖北入昆人员图表Controller
 * @author GXP
 * @date 2020/2/27 17:16
 */
@Api(tags = "第五屏：湖北入昆人员图表 ")
@RestController
@RequestMapping("/api/yndp/HubeiPeopleEchart")
public class YndpFiveHubeiPeopleEchartController {

    @Autowired
    YndpFiveHubeiPeopleEchartService YndpFiveHubeiPeopleEchartService;

    @ApiOperation("根据日期查询湖北入昆人员图表 ")
    @GetMapping(value = "/getYndpFiveHubeiPeopleEchartList")
    public Result getYndpFiveHubeiPeopleEchartList(@RequestParam String date, HttpServletRequest request, HttpServletResponse response) {

        List<YndpFiveHubeiPeopleEchart> YndpFiveHubeiPeopleEchartList = YndpFiveHubeiPeopleEchartService.getYndpFiveHubeiPeopleEchartList(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(YndpFiveHubeiPeopleEchartList);
        result.setMessage("成功");
        return result;
    }

}
