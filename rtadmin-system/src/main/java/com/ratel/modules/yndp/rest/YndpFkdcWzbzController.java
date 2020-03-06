package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFkdcWzbz;
import com.ratel.modules.yndp.service.YndpFkdcWzbzService;
import com.ratel.modules.yndp.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DDXS
 * @date 2020/2/26 9:45
 */
@Api(tags = "第二屏：物资保障")
@RestController
@RequestMapping("/api/yndp/wzbz")
public class YndpFkdcWzbzController {
    
    @Autowired
    YndpFkdcWzbzService yndpFkdcWzbzService;

    @ApiOperation("根据所选机构ID查询出物资保障列表")
    @GetMapping(value = "/findWzbzListByJgId")
    @ResponseBody
    public Result findWzbzListByJgId(YndpFkdcWzbz yndpFkdcWzbz) {

        // 1. 获取所选择机构ID
        String jgId = yndpFkdcWzbz.getJgid();
        // 2. 根据所选择的机构ID查询出列表
        List<YndpFkdcWzbz> yndpFkdcZypzList = yndpFkdcWzbzService.findWzbzListByJgId(jgId);
//        return new ResponseEntity<>(yndpFkdcZypzList, HttpStatus.OK);

        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpFkdcZypzList);
        result.setMessage("成功");
        return result;
    }
}
