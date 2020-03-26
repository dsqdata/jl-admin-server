package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFourSchool;
import com.ratel.modules.yndp.domain.YndpFourSchoolMsg;
import com.ratel.modules.yndp.domain.YndpThreePageSchool;
import com.ratel.modules.yndp.service.YndpFourSchoolService;
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
import java.util.Map;

/**
 * 学校复工情况
 * @author xjl
 * @date 2020/3/9
 */
@Api(tags = "校园疫情防控-学校信息")
@RestController
@RequestMapping("/api/yndp/xxxx")
public class YndpFourSchoolController {
    
    @Autowired
    YndpFourSchoolService yndpFourSchoolService;

    @ApiOperation("查询出学校坐标")
    @GetMapping(value = "/getXxjw")
    public Result getXxjw(@RequestParam String name,HttpServletRequest request, HttpServletResponse response) {

        // 1. 根据所选择的机构ID查询出列表
        List<YndpFourSchool> yndpFourSchool = yndpFourSchoolService.getXxjw(name);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFourSchool);
        result.setMessage("成功");
        return result;
    }


    @ApiOperation("查询出学校总数")
    @GetMapping(value = "/getXxzs")
    public Result getXxzs(HttpServletRequest request, HttpServletResponse response) {

        // 1. 根据所选择的机构ID查询出列表
        String count = yndpFourSchoolService.getXxzs();
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(count);
        result.setMessage("成功");
        return result;
    }

    @ApiOperation("查询出学校图例")
    @GetMapping(value = "/getXxtl")
    public Result getXxtl(HttpServletRequest request, HttpServletResponse response) {

        // 1. 根据所选择的机构ID查询出列表
        List<Map> yndpFourSchool = yndpFourSchoolService.getXxtl();
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFourSchool);
        result.setMessage("成功");
        return result;
    }

    @ApiOperation("查询学校各种情况分类数")
    @GetMapping(value = "/getXxfls")
    public Result getXxfls(@RequestParam String date,HttpServletRequest request, HttpServletResponse response) {

        // 1. 根据所选择的机构ID查询出列表
        List<String> yndpFourSchool = yndpFourSchoolService.getXxfls(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFourSchool);
        result.setMessage("成功");
        return result;
    }

    @ApiOperation("查询各学校在昆教职工情况跟踪-有发热、咳嗦、呼吸困难等症状 统计数")
    @GetMapping(value = "/getXxtjs21")
    public Result getXxtjs21(@RequestParam String date,@RequestParam String name,HttpServletRequest request, HttpServletResponse response) {

        // 1. 根据所选择的机构ID查询出列表
        List<Map> yndpFourSchool = yndpFourSchoolService.getXxtjs21(date,name);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFourSchool);
        result.setMessage("成功");
        return result;
    }

    @ApiOperation("查询各学校在昆教职工情况跟踪-新发感染病例统计数")
    @GetMapping(value = "/getXxtjs25")
    public Result getXxtjs25(@RequestParam String date,@RequestParam String name,HttpServletRequest request, HttpServletResponse response) {

        // 1. 根据所选择的机构ID查询出列表
        List<Map> yndpFourSchool = yndpFourSchoolService.getXxtjs25(date,name);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFourSchool);
        result.setMessage("成功");
        return result;
    }

    @ApiOperation("查询各学校在昆教职工情况跟踪-确诊病例统计数")
    @GetMapping(value = "/getXxtjs26")
    public Result getXxtjs26(@RequestParam String date,@RequestParam String name,HttpServletRequest request, HttpServletResponse response) {

        // 1. 根据所选择的机构ID查询出列表
        List<Map> yndpFourSchool = yndpFourSchoolService.getXxtjs26(date,name);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFourSchool);
        result.setMessage("成功");
        return result;
    }
    @ApiOperation("查询各学校在昆教职工情况跟踪-疑似病例统计数")
    @GetMapping(value = "/getXxtjs27")
    public Result getXxtjs27(@RequestParam String date,@RequestParam String name,HttpServletRequest request, HttpServletResponse response) {

        // 1. 根据所选择的机构ID查询出列表
        List<Map> yndpFourSchool = yndpFourSchoolService.getXxtjs27(date,name);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFourSchool);
        result.setMessage("成功");
        return result;
    }


}
