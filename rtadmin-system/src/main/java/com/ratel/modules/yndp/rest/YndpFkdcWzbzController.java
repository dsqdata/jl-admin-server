package com.ratel.modules.yndp.rest;

import com.ratel.modules.yndp.service.YndpFkdcWzbzService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DDXS
 * @date 2020/2/26 9:45
 */
@Api(tags = "物资保障")
@RestController
@RequestMapping("/api/wzbz")
public class YndpFkdcWzbzController {
    
    @Autowired
    YndpFkdcWzbzService yndpFkdcWzbzService;


}
