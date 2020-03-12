package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpThreePageReworkEchart;
import com.ratel.modules.yndp.service.YndpThreePageReworkEchartService;
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
 * 社区/村人员核查和信息采集
 * @author GXP
 * @date 2020/2/27 17:16
 */
@Api(tags = "第三屏：社区/村人员核查和信息采集 ")
@RestController
@RequestMapping("/api/yndp/ReworkEchart")
public class YndpThreePageReworkEchartController {

    @Autowired
    YndpThreePageReworkEchartService YndpThreePageReworkEchartService;

    @ApiOperation("根据日期查询社区/村人员核查和信息采集 ")
    @GetMapping(value = "/getYndpThreePageReworkEchartList")
    public Result getYndpThreePageReworkEchartList(@RequestParam String date, HttpServletRequest request, HttpServletResponse response) {

        List<YndpThreePageReworkEchart> YndpThreePageAllReworkEchartList = YndpThreePageReworkEchartService.getYndpThreePageReworkEchartList(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(YndpThreePageAllReworkEchartList);
        result.setMessage("成功");
        return result;
    }

}
