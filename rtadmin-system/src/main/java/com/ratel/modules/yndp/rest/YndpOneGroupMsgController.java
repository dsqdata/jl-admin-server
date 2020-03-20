package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpOneGroupMsg;
import com.ratel.modules.yndp.domain.YndpOneLeadingGroup;
import com.ratel.modules.yndp.service.YndpOneGroupMsgService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 第一屏-各小组信息Controller
 * @author DDXS
 * @date 2020/3/17 16:19
 */
@Api(tags = "第一屏-各小组信息")
@RestController
@RequestMapping("/api/yndp/groupMsg")
public class YndpOneGroupMsgController {

    @Autowired
    YndpOneGroupMsgService yndpOneGroupMsgService;

    @ApiOperation("根据类型查询第一屏-各小组信息")
    @GetMapping(value = "/getGroupMsg")
    public Result getGroupMsg(@RequestParam String type,HttpServletRequest request, HttpServletResponse response) {

        List<YndpOneGroupMsg> yndpOneGroupMsgList = yndpOneGroupMsgService.getGroupMsgByType(type);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpOneGroupMsgList);
        result.setMessage("成功");
        return result;
    }

    @ApiOperation("查询第一屏-各小组信息所有")
    @GetMapping(value = "/getGroupMsgAll")
    public Result getGroupMsgAll(HttpServletRequest request, HttpServletResponse response) {
        List<YndpOneGroupMsg> yndpOneGroupMsgListAll = yndpOneGroupMsgService.getGroupMsgAll();
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpOneGroupMsgListAll);
        result.setMessage("成功");
        return result;
    }

}
