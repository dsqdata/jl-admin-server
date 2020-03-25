package com.ratel.modules.docs.rest;

import com.ratel.framework.exception.BadRequestException;
import com.ratel.modules.docs.domain.ModDocs;
import com.ratel.modules.docs.service.ModDocsService;
import com.ratel.modules.docs.service.dto.ModDocsQueryCriteria;
import com.ratel.modules.logging.aop.log.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;

@RestController
@RequestMapping("/api/modDocs")
@Api(tags = "文档：文档管理")
public class ModDocsController {

    @Autowired
    private ModDocsService modDocsService;

    private static final String ENTITY_NAME = "modDocs";

    @GetMapping("/getPageData")
    public Page<ModDocs> getPageData(@PathParam("userId") Integer userId,
                                     @PathParam("currentPage") Integer currentPage,
                                     @PathParam("pageSize") Integer pageSize) {
        // 同步前端传回的当前页参数
        currentPage = currentPage - 1;
        return modDocsService.getPageData(userId, currentPage, pageSize);
    }

    @Log("导出文档数据")
    @ApiOperation("导出文档数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('docs:list')")
    public void download(HttpServletResponse response, ModDocsQueryCriteria criteria) throws IOException {
        modDocsService.download(modDocsService.queryAll(criteria), response);
    }

    @Log("查询文档")
    @ApiOperation("查询文档")
    @GetMapping(value = "/all")
    @PreAuthorize("@el.check('docs:list')")
    public ResponseEntity<Object> all() {
        return new ResponseEntity<>(modDocsService.queryAll(new ModDocsQueryCriteria()), HttpStatus.OK);
    }

    @Log("查询文档")
    @ApiOperation("查询文档")
    @GetMapping
    @PreAuthorize("@el.check('docs:list')")
    public ResponseEntity<Object> getModDocs(ModDocsQueryCriteria resources, Pageable pageable) {
        return new ResponseEntity<>(modDocsService.queryAll(resources, pageable), HttpStatus.OK);
    }


    @Log("查询文档")
    @ApiOperation("查询文档")
    @GetMapping(value = "/getModDocsById/{id}")
    @PreAuthorize("@el.check('docs:list')")
    public ResponseEntity<Object> getModDocsById(@PathVariable Long id) {
        return new ResponseEntity<>(modDocsService.findOne(id), HttpStatus.OK);
    }


    @Log("新增文档")
    @ApiOperation("新增文档")
    @PostMapping
    @PreAuthorize("@el.check('docs:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody ModDocs resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity<>(modDocsService.save(resources), HttpStatus.CREATED);
    }

    @Log("修改文档")
    @ApiOperation("修改文档")
    @PutMapping
    @PreAuthorize("@el.check('docs:edit')")
    public ResponseEntity<Object> update(@Validated(ModDocs.Update.class) @RequestBody ModDocs resources) {
        modDocsService.save(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除文档")
    @ApiOperation("删除文档")
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("@el.check('docs:del')")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        modDocsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Log("删除文档")
    @ApiOperation("删除文档")
    @DeleteMapping
    @PreAuthorize("@el.check('docs:del')")
    public ResponseEntity<Object> delete(@RequestBody Long[] ids) {
        modDocsService.deleteBatch(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
