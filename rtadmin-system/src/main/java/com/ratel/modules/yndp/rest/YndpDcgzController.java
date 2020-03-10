package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpThreePageSchool;
import com.ratel.modules.yndp.domain.YndpThreePageSupervisor;
import com.ratel.modules.yndp.service.YndpDcgzService;
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

/**
 * 督导组工作开展
 * @author xjl
 * @date 2020/3/9
 */
@Api(tags = "第三屏：督导组工作开展")
@RestController
@RequestMapping("/api/yndp/dcgz")
public class YndpDcgzController {
    
    @Autowired
    YndpDcgzService yndpDcgzService;

    @ApiOperation("根据日期查询出督导组工作开展")
    @GetMapping(value = "/getDcgzList")
    public Result getXxfgList(@RequestParam String date,@RequestParam String type,HttpServletRequest request, HttpServletResponse response) {

        // 1. 根据所选择的机构ID查询出列表
        YndpThreePageSupervisor yndpDcgzList = yndpDcgzService.getDcgzList(date,type);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpDcgzList);
        result.setMessage("成功");
        return result;
    }


}
