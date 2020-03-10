package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpThreePageCollection;
import com.ratel.modules.yndp.service.YndpThreePageCollectionService;
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
 * 社区/村人员核查和信息采集
 * @author GXP
 * @date 2020/2/27 17:16
 */
@Api(tags = "第三屏：社区/村人员核查和信息采集 ")
@RestController
@RequestMapping("/api/yndp/Collection")
public class YndpThreePageCollectionController {

    @Autowired
    YndpThreePageCollectionService YndpThreePageCollectionService;

    @ApiOperation("根据日期查询社区/村人员核查和信息采集 ")
    @GetMapping(value = "/getYndpThreePageCollection")
    public Result getYndpThreePageCollection(@RequestParam String date, HttpServletRequest request, HttpServletResponse response) {

        YndpThreePageCollection yndpThreePageCollection = YndpThreePageCollectionService.getYndpThreePageCollection(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(yndpThreePageCollection);
        result.setMessage("成功");
        return result;
    }

    @ApiOperation("根据日期查询社区/村人员核查和信息采集 ")
    @GetMapping(value = "/getYndpThreePageAllCollectionList")
    public Result getYndpThreePageAllCollectionList(@RequestParam String date, HttpServletRequest request, HttpServletResponse response) {

        List<YndpThreePageCollection> YndpThreePageAllCollectionList = YndpThreePageCollectionService.getYndpThreePageAllCollectionList(date);
        Result result = new Result();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(YndpThreePageAllCollectionList);
        result.setMessage("成功");
        return result;
    }

}
