package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpThreePageWorkstation;
import com.ratel.modules.yndp.service.YndpThreePageWorkstationService;
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
 * 留验站工作表
 * @author GXP
 * @date 2020/2/27 17:16
 */
@Api(tags = "第三屏：留验站工作表 ")
@RestController
@RequestMapping("/api/yndp/Workstation")
public class YndpThreePageWorkstationController {

    @Autowired
    YndpThreePageWorkstationService YndpThreePageWorkstationService;

    @ApiOperation("留验站工作表 ")
    @GetMapping(value = "/getYndpThreePageWorkstationList")
    public Result getYndpThreePageWorkstationList( HttpServletRequest request, HttpServletResponse response) {

        List<YndpThreePageWorkstation> YndpThreePageWorkstationList = YndpThreePageWorkstationService.getYndpThreePageWorkstationList();
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(YndpThreePageWorkstationList);
        result.setMessage("成功");
        return result;
    }

}
