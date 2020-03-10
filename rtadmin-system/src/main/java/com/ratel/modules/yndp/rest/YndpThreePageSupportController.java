package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpThreePageSupport;
import com.ratel.modules.yndp.service.YndpThreePageSupportService;
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
 * 物资保供
 * @author GXP
 * @date 2020/2/27 17:16
 */
@Api(tags = "第三屏：物资保供 ")
@RestController
@RequestMapping("/api/yndp/Support")
public class YndpThreePageSupportController {

    @Autowired
    YndpThreePageSupportService YndpThreePageSupportService;

    @ApiOperation("根据日期查询物资保供 ")
    @GetMapping(value = "/getYndpThreePageSupport")
    public Result getYndpThreePageSupport(@RequestParam String date, HttpServletRequest request, HttpServletResponse response) {

        YndpThreePageSupport yndpThreePageSupport = YndpThreePageSupportService.getYndpThreePageSupport(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpThreePageSupport);
        result.setMessage("成功");
        return result;
    }

}
