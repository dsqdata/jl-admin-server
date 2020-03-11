package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpThreePageInvestigationEchart;
import com.ratel.modules.yndp.domain.YndpThreePageRework;
import com.ratel.modules.yndp.service.YndpThreePageInvestigationEchartService;
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
 * 固定检查点排查-echart 图
 * @author xjl
 * @date 2020/3/9
 */
@Api(tags = "第三屏：固定检查点排查-echart 图")
@RestController
@RequestMapping("/api/yndp/gdjcpcec")
public class YndpThreePageInvestigationEchartController {
    
    @Autowired
    YndpThreePageInvestigationEchartService yndpThreePageInvestigationEchartService;

    @ApiOperation("根据日期查询出企业复工复产情况")
    @GetMapping(value = "/getGdjcpcEList")
    public Result getGdjcpcEList(@RequestParam String date,HttpServletRequest request, HttpServletResponse response) {

        // 1. 根据所选择的机构ID查询出列表
        List<YndpThreePageInvestigationEchart> yndpGdjcpcEList = yndpThreePageInvestigationEchartService.getGdjcpcEList (date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpGdjcpcEList);
        result.setMessage("成功");
        return result;
    }


}
