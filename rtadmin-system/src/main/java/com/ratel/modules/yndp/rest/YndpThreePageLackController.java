package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpThreePageLack;
import com.ratel.modules.yndp.service.YndpThreePageLackService;
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
 * 紧缺物资
 * @author GXP
 * @date 2020/2/27 17:16
 */
@Api(tags = "第三屏：紧缺物资 ")
@RestController
@RequestMapping("/api/yndp/Lack")
public class YndpThreePageLackController {

    @Autowired
    YndpThreePageLackService YndpThreePageLackService;

    @ApiOperation("根据日期查询紧缺物资 ")
    @GetMapping(value = "/getYndpThreePageLackList")
    public Result getYndpThreePageLackList(@RequestParam String date, HttpServletRequest request, HttpServletResponse response) {

        List<YndpThreePageLack> YndpThreePageLackList = YndpThreePageLackService.getYndpThreePageLackList(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(YndpThreePageLackList);
        result.setMessage("成功");
        return result;
    }

}
