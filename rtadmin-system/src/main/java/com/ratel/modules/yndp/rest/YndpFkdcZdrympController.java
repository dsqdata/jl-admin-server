package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.domain.YndpFkdcZdrymp;
import com.ratel.modules.yndp.service.YndpFkdcZdrympService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/yndp/zdrymp")
@Api(tags = "重点人员摸排管理")
public class YndpFkdcZdrympController {

    @Autowired
    private YndpFkdcZdrympService yndpFkdcZdrympService;

    @GetMapping(value = "/getZdrympData")
    @ApiOperation("重点人员摸排数据")
    public ResponseEntity<Object> getZdrympData(YndpFkdcZdrymp yndpFkdcZdrymp) {
        return new ResponseEntity<>(yndpFkdcZdrympService.getZdrympData(yndpFkdcZdrymp), HttpStatus.OK);
    }
}
