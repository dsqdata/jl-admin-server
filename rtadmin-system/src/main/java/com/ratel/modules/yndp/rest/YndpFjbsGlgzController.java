package com.ratel.modules.yndp.rest;

import com.github.pagehelper.PageInfo;
import com.ratel.modules.yndp.domain.YndpFkbsJg;
import com.ratel.modules.yndp.domain.YndpFkbsWg;
import com.ratel.modules.yndp.domain.YndpFkbsWgcy;
import com.ratel.modules.yndp.service.YndpFkbsJgService;
import com.ratel.modules.yndp.service.YndpFkbsWgService;
import com.ratel.modules.yndp.service.YndpFkbsWgcyService;
import com.ratel.modules.yndp.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 防控部署-管理工作Controller
 * @author DDXS
 * @date 2020/2/28 12:26
 */
@Api(tags = "第一屏：管理工作")
@RestController
@RequestMapping("/api/yndp/glgz")
public class YndpFjbsGlgzController {

    @Autowired
    YndpFkbsJgService yndpFkbsJgService;
    @Autowired
    YndpFkbsWgService yndpFkbsWgService;
    @Autowired
    YndpFkbsWgcyService yndpFkbsWgcyService;

    @ApiOperation("首页：查询出一屏页面所有机构")
    @GetMapping(value = "/getAllJg")
    public Result getAllJg(HttpServletRequest request, HttpServletResponse response) {

        // 查询出一屏页面所有机构
        List<YndpFkbsJg> yndpFkbsJgList = yndpFkbsJgService.getAllJg();
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFkbsJgList);
        result.setMessage("成功");
        return result;
    }


    @ApiOperation("根据机构ID查询出机构")
    @GetMapping(value = "/getJg")
    public Result getJg(@RequestParam String jgId, HttpServletRequest request, HttpServletResponse response) {
        // 根据机构ID查询出上级机构
        YndpFkbsJg jg = yndpFkbsJgService.getJg(jgId);
        Map<String,YndpFkbsJg> map = new HashMap<String,YndpFkbsJg>();
        map.put("jg",jg);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(map);
        result.setMessage("成功");
        return result;
    }

    @ApiOperation("根据机构ID查询出父机构")
    @GetMapping(value = "/getSjJg")
    public Result getsjJg(@RequestParam String jgId, HttpServletRequest request, HttpServletResponse response) {
        // 根据机构ID查询出上级机构
        YndpFkbsJg sjjg = yndpFkbsJgService.getSjJg(jgId);
        Map<String,YndpFkbsJg> map = new HashMap<String,YndpFkbsJg>();
        map.put("sjjg",sjjg);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(map);
        result.setMessage("成功");
        return result;
    }

    @ApiOperation("根据机构ID查询出下级机构列表")
    @GetMapping(value = "/getxjJgList")
    public Result getXjJgList(@RequestParam String jgId, HttpServletRequest request, HttpServletResponse response) {
        // 根据机构ID查询出下级级机构列表
        List<YndpFkbsJg> yndpFkbsJgList = yndpFkbsJgService.getXjJgList(jgId);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFkbsJgList);
        result.setMessage("成功");
        return result;
    }

    @ApiOperation("根据机构ID查询所有网格")
    @GetMapping(value = "/getWgList")
    public Result getWgList(@RequestParam String jgId,@RequestParam Integer pageNum, HttpServletRequest request, HttpServletResponse response) {
        if(pageNum==null){
            pageNum=1;
        }
        PageRequest pageRequest =
                new PageRequest(pageNum,3,new Sort(Sort.Direction.DESC,"id"));
       PageInfo<YndpFkbsWg> yndpFkbsWgList = yndpFkbsWgService.getWgList(jgId,pageRequest);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFkbsWgList);
        result.setMessage("成功");
        return result;
    }


    @ApiOperation("根据网格ID查询出网格成员列表")
    @GetMapping(value = "/getWgcyList")
    public Result getWgcyList(@RequestParam String wgId,@RequestParam Integer pageNum, HttpServletRequest request, HttpServletResponse response) {
        if(pageNum==null){
            pageNum=1;
        }
        PageRequest pageRequest =
                new PageRequest(pageNum,3,new Sort(Sort.Direction.DESC,"id"));
        // 根据网格ID查询出网格成员列表
        PageInfo<YndpFkbsWgcy> yndpFkbsWgcyList = yndpFkbsWgcyService.getWgcyList(wgId,pageRequest);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFkbsWgcyList);
        result.setMessage("成功");
        return result;

    }

}
