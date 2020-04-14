package com.ratel.modules.jladmin.rest;

import com.ratel.framework.core.web.MultiRequestBody;
import com.ratel.modules.jladmin.domain.TestDomain;
import com.ratel.modules.jladmin.rest.dto.TestQueryCriteria;
import com.ratel.modules.jladmin.service.TestService;
import com.ratel.modules.logging.aop.log.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "接龙Test")
@RestController
@RequestMapping("/api/jl/test")
public class TestController {

    @Autowired
    private TestService testService;

    /**
     *
     * http://localhost:8000/api/jl/test?page=1&size=10&sort=id,username,desc
     *
     * @param criteria
     * @param pageable
     * @return
     */
    @Log("实例查询-分页")
    @ApiOperation(value = "实例查询-分页")
    @GetMapping
    public ResponseEntity<Object> getTests(TestQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(testService.queryAll(criteria, pageable), HttpStatus.OK);
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
    public ResponseEntity<Object> postTests(@MultiRequestBody TestQueryCriteria criteria,
                                            @MultiRequestBody Integer page,
                                            @MultiRequestBody Integer size) {
        PageRequest pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(testService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    /**
     * http://localhost:8000/api/demo/postParamUsers?page=1&size=10&sort=id,username,desc
     * body参数 {"id":1}
     *
     * @param criteria
     * @param pageable
     * @return
     */
    @Log("实例查询-分页")
    @ApiOperation(value = "实例查询-分页")
    @PostMapping(value = "/postParamUsers")
    public ResponseEntity<Object> postParamUsers(@RequestBody TestQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(testService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @Log("实例查询-用户查询")
    @ApiOperation(value = "实例查询-用户查询")
    @PostMapping(value = "/getUser")
    @GetMapping
    public ResponseEntity<TestDomain> getUser(@RequestBody TestDomain user) {
        return new ResponseEntity<>(testService.getUser(user), HttpStatus.OK);
    }

}
