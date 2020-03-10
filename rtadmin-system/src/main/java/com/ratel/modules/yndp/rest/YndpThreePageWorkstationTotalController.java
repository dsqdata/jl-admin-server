package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpThreePageWorkstationTotal;
import com.ratel.modules.yndp.service.YndpThreePageWorkstationTotalService;
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
 * 留验站工作动态
 * @author GXP
 * @date 2020/2/27 17:16
 */
@Api(tags = "第三屏：留验站工作动态 ")
@RestController
@RequestMapping("/api/yndp/WorkstationTotal")
public class YndpThreePageWorkstationTotalController {

    @Autowired
    YndpThreePageWorkstationTotalService YndpThreePageWorkstationTotalService;

    @ApiOperation("根据日期和留验站ID查询留验站工作动态 ")
    @GetMapping(value = "/getYndpThreePageWorkstationTotal")
    public Result getYndpThreePageWorkstationTotalList(@RequestParam String date, @RequestParam String workstation_id,HttpServletRequest request, HttpServletResponse response) {

        YndpThreePageWorkstationTotal yndpThreePageWorkstationTotal = YndpThreePageWorkstationTotalService.getYndpThreePageWorkstationTotal(date,workstation_id);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpThreePageWorkstationTotal);
        result.setMessage("成功");
        return result;
    }

}
