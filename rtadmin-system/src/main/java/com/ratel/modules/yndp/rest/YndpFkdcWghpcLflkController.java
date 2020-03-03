package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFkdcFkxc;
import com.ratel.modules.yndp.domain.YndpFkdcWghpcLflk;
import com.ratel.modules.yndp.service.YndpFkdcWghpcLflkService;
import com.ratel.modules.yndp.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 网格化排查及联防联控
 * @author DDXS
 * @date 2020/2/27 17:16
 */
@Api(tags = "第二屏：网格化排查及联防联控")
@RestController
@RequestMapping("/api/yndp/wghpclflk")
public class YndpFkdcWghpcLflkController {

    @Autowired
    YndpFkdcWghpcLflkService yndpFkdcWghpcLflkService;

    @ApiOperation("根据机构ID查询出防控宣传列表")
    @GetMapping(value = "/getPcjlflkList")
    public Result getPcjlflkList(@RequestParam String jgId, HttpServletRequest request, HttpServletResponse response) {

        //1. 根据所选择的机构ID查询出列表
        List<YndpFkdcWghpcLflk> yndpFkdcWghpcLflkList = yndpFkdcWghpcLflkService.getPcjlflkList(jgId);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFkdcWghpcLflkList);
        result.setMessage("成功");
        return result;
    }

}
