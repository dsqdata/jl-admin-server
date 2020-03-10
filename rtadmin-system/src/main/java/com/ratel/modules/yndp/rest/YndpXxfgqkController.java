package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpThreePageSchool;
import com.ratel.modules.yndp.service.YndpXxfgService;
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
 * 学校复工情况
 * @author xjl
 * @date 2020/3/9
 */
@Api(tags = "第三屏：学校复工情况")
@RestController
@RequestMapping("/api/yndp/xxfg")
public class YndpXxfgqkController {
    
    @Autowired
    YndpXxfgService yndpXxfgService;

    @ApiOperation("根据日期查询出学校复工情况")
    @GetMapping(value = "/getXxfgList")
    public Result getXxfgList(@RequestParam String date,HttpServletRequest request, HttpServletResponse response) {

        // 1. 根据所选择的机构ID查询出列表
        YndpThreePageSchool yndpXxfgList = yndpXxfgService.getXxfgList(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpXxfgList);
        result.setMessage("成功");
        return result;
    }


}
