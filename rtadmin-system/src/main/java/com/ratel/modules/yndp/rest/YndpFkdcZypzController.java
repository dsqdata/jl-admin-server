package com.ratel.modules.yndp.rest;

import com.ratel.framework.utils.SecurityUtils;
import com.ratel.modules.system.service.dto.MenuDto;
import com.ratel.modules.system.service.dto.UserDto;
import com.ratel.modules.yndp.domain.YndpFkdcZypz;
import com.ratel.modules.yndp.service.YndpFkdcZypzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author DDXS
 * @date 2020/2/26 13:36
 */
@Api(tags = "资源配置")
@RestController
@RequestMapping("/api/zypz")
public class YndpFkdcZypzController {

    @Autowired
    YndpFkdcZypzService yndpFkdcZypzService;

    @ApiOperation("根据所选机构ID查询出资源配置列表")
    @GetMapping(value = "/findListByJgId")
    public ResponseEntity<Object> findListByJgId( HttpServletRequest request,HttpServletResponse response) {

        // 1. 获取所选择机构ID
        String jgId = "88";
        // 2. 根据所选择的机构ID查询出列表
        List<YndpFkdcZypz> yndpFkdcZypzList = yndpFkdcZypzService.findListByJgId(jgId);
        return new ResponseEntity<>(yndpFkdcZypzList, HttpStatus.OK);
    }
}
