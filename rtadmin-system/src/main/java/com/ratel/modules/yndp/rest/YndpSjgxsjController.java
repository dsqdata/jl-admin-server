package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFkbsJg;
import com.ratel.modules.yndp.domain.YndpSjgxsj;
import com.ratel.modules.yndp.service.YndpSjgxsjService;
import com.ratel.modules.yndp.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 数据时间更新表
 * @author DDXS
 * @date 2020/3/2 16:18
 */
@Api(tags = "数据时间更新表")
@RestController
@RequestMapping("/api/yndp/sjsjgx")
public class YndpSjgxsjController {
    @Autowired
    YndpSjgxsjService yndpSjgxsjService;
    @ApiOperation("查询出数据时间更新")
    @GetMapping(value = "/getGxsj")
    public Result getGxsj(HttpServletRequest request, HttpServletResponse response) {
        //查询出数据时间更新
        YndpSjgxsj yndpSjgxsj = yndpSjgxsjService.getGxsj();
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpSjgxsj);
        result.setMessage("成功");
        return result;
    }

}
