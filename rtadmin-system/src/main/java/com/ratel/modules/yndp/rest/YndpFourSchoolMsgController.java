package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFourSchoolMsg;
import com.ratel.modules.yndp.service.YndpFourSchoolMsgService;
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
 * 学校疫情信息
 * @author GXP
 * @date 2020/2/27 17:16
 */
@Api(tags = "第四屏：学校疫情信息 ")
@RestController
@RequestMapping("/api/yndp/SchoolMsg")
public class YndpFourSchoolMsgController {

    @Autowired
    YndpFourSchoolMsgService YndpFourSchoolMsgService;

    /*@ApiOperation("根据日期和留验站ID查询学校疫情信息 ")
    @GetMapping(value = "/getYndpFourSchoolMsg")
    public Result getYndpFourSchoolMsg(@RequestParam String date, @RequestParam String school_id,HttpServletRequest request, HttpServletResponse response) {

        YndpFourSchoolMsg YndpFourSchoolMsg = YndpFourSchoolMsgService.getYndpFourSchoolMsg(date,school_id);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(YndpFourSchoolMsg);
        result.setMessage("成功");
        return result;
    }*/

    @ApiOperation("根据日期和学校ID和人员类型查询学校疫情信息Echart图 ")
    @GetMapping(value = "/getYndpFourSchoolMsgList")
    public Result getYndpFourSchoolMsgList(@RequestParam String date, @RequestParam String school_id, @RequestParam int type,HttpServletRequest request, HttpServletResponse response) {

        List<YndpFourSchoolMsg> YndpFourSchoolMsgList = YndpFourSchoolMsgService.getYndpFourSchoolMsgList(date,school_id,type);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(YndpFourSchoolMsgList);
        result.setMessage("成功");
        return result;
    }
}
