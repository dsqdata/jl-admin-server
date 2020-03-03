package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFkdcFkxc;
import com.ratel.modules.yndp.domain.YndpFkdcZypz;
import com.ratel.modules.yndp.service.YndpFkdcFkXcService;
import com.ratel.modules.yndp.service.YndpFkdcWzbzService;
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
 * 防控宣传
 * @author DDXS
 * @date 2020/2/26 9:45
 */
@Api(tags = "第二屏：防控宣传")
@RestController
@RequestMapping("/api/yndp/fkxc")
public class YndpFkdcFkxcController {
    
    @Autowired
    YndpFkdcFkXcService yndpFkdcFkXcService;

    @ApiOperation("根据机构ID查询出防控宣传列表")
    @GetMapping(value = "/getFkxcList")
    public Result getFkxcList(@RequestParam String jgId,HttpServletRequest request, HttpServletResponse response) {

        // 1. 根据所选择的机构ID查询出列表
        List<YndpFkdcFkxc> yndpFkdcFkxcList = yndpFkdcFkXcService.getFkxcList(jgId);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFkdcFkxcList);
        result.setMessage("成功");
        return result;
    }


}
