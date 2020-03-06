package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFkdcZypz;
import com.ratel.modules.yndp.service.YndpFkdcZypzService;
import com.ratel.modules.yndp.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author DDXS
 * @date 2020/2/26 13:36
 */
@Api(tags = "第二屏：资源配置")
@RestController
@RequestMapping("/api/yndp/zypz")
public class YndpFkdcZypzController {

    @Autowired
    YndpFkdcZypzService yndpFkdcZypzService;

    @ApiOperation("根据所选机构ID查询出资源配置数据")
    @GetMapping(value = "/findZypzByJgId")
    public Result findZypzByJgId(@RequestParam String jgId) {

        // 1. 获取所选择机构ID
     /*   String jgId = yndpFkdcZypz.getJgid();*/
        // 2. 根据所选择的机构ID查询出列表
        YndpFkdcZypz zypz = yndpFkdcZypzService.findZypzByJgId(jgId);
//        return new ResponseEntity<>(zypz, HttpStatus.OK);

        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(zypz);
        result.setMessage("成功");
        return result;

    }
}
