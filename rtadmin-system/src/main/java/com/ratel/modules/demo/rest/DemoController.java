package com.ratel.modules.demo.rest;

import com.ratel.framework.core.web.MultiRequestBody;
import com.ratel.modules.demo.rest.dto.DemoQueryCriteria;
import com.ratel.modules.demo.service.DemoService;
import com.ratel.modules.logging.aop.log.Log;
import com.ratel.modules.system.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "实例")
@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    /**
     * http://localhost:8000/api/demo/postParamUsers?page=1&size=10&sort=id,username,desc
     * @param criteria
     * @param pageable
     * @return
     */
    @Log("实例查询-分页")
    @ApiOperation(value = "实例查询-分页")
    @GetMapping
    public ResponseEntity<Object> getUsers(DemoQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(demoService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    /**
     * 前台访问 http://localhost:8000/api/demo/getUsers
     * body参数 {"id":1,"page":2,"size":10}
     *
     * @param criteria
     * @param page
     * @param size
     * @return
     */
    @Log("实例查询-分页")
    @ApiOperation(value = "实例查询-分页")
    @PostMapping(value = "/getUsers")
    public ResponseEntity<Object> postUsers(@MultiRequestBody DemoQueryCriteria criteria,
                                            @MultiRequestBody Integer page,
                                            @MultiRequestBody Integer size) {
        PageRequest pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(demoService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    /**
     *  http://localhost:8000/api/demo/postParamUsers?page=1&size=10&sort=id,username,desc
     *  body参数 {"id":1}
     *
     * @param criteria
     * @param pageable
     * @return
     */
    @Log("实例查询-分页")
    @ApiOperation(value = "实例查询-分页")
    @PostMapping(value = "/postParamUsers")
    public ResponseEntity<Object> postParamUsers(@RequestBody DemoQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(demoService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @Log("实例查询-用户查询")
    @ApiOperation(value = "实例查询-用户查询")
    @PostMapping(value = "/getUser")
    @GetMapping
    public ResponseEntity<User> getUser(@RequestBody User user) {
        return new ResponseEntity<>(demoService.getUser(user), HttpStatus.OK);
    }

}
