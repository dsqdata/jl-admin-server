package com.ratel.modules.updata.rest;

import com.ratel.config.DataScope;
import com.ratel.framework.exception.BadRequestException;
import com.ratel.modules.docs.domain.ModDocs;
import com.ratel.modules.logging.aop.log.Log;
import com.ratel.modules.updata.domain.YqpcMain;
import com.ratel.modules.updata.service.ModYqpcMainService;
import com.ratel.modules.updata.service.dto.YqpcQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/modYqpc")
@Api(tags = "文档：疫情排查")
public class YqpcController {

    @Autowired
    private ModYqpcMainService modYqpcMainService;

    @Autowired
    private DataScope dataScope;

    private static final String ENTITY_NAME = "modYqpc";

    @Log("导出文档数据")
    @ApiOperation("导出文档数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('pcdj:list')")
    public void download(HttpServletResponse response, YqpcQueryCriteria criteria) throws IOException {
        // 数据权限
        criteria.setSystemDeptIds(dataScope.getDeptIds());
        modYqpcMainService.download(modYqpcMainService.queryAll(criteria), response);
    }

    @Log("查询文档")
    @ApiOperation("查询文档")
    @GetMapping(value = "/all")
    @PreAuthorize("@el.check('pcdj:list')")
    public ResponseEntity<Object> all() {
        return new ResponseEntity<>(modYqpcMainService.queryAll(new YqpcQueryCriteria()), HttpStatus.OK);
    }

    @Log("查询文档")
    @ApiOperation("查询文档")
    @GetMapping
    @PreAuthorize("@el.check('pcdj:list')")
    public ResponseEntity<Object> getModDocs(YqpcQueryCriteria resources, Pageable pageable) {
        return new ResponseEntity<>(modYqpcMainService.queryAll(resources, pageable), HttpStatus.OK);
    }


    @Log("查询文档")
    @ApiOperation("查询文档")
    @GetMapping(value = "/getModYqpcById/{id}")
    @PreAuthorize("@el.check('pcdj:list')")
    public ResponseEntity<Object> getModDocsById(@PathVariable Long id) {
        return new ResponseEntity<>(modYqpcMainService.findOne(id), HttpStatus.OK);
    }


    @Log("新增文档")
    @ApiOperation("新增文档")
    @PostMapping
    @PreAuthorize("@el.check('pcdj:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody YqpcMain resources, @RequestParam("file") MultipartFile file) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity<>(modYqpcMainService.save(resources), HttpStatus.CREATED);
    }

    @ApiOperation("上传文件")
    @PostMapping(value = "/importData")
    @PreAuthorize("@el.check('pcdj:add')")
    public ResponseEntity<Object> create(@RequestParam("file") MultipartFile file) {
        modYqpcMainService.getOne(new Long(888));
        PageRequest pageRequest =
                new PageRequest(1,10,new Sort(Sort.Direction.DESC,"id"));
        modYqpcMainService.findPage(pageRequest);
        return new ResponseEntity<>(new Object(), HttpStatus.CREATED);
    }

    @Log("修改文档")
    @ApiOperation("修改文档")
    @PutMapping
    @PreAuthorize("@el.check('pcdj:edit')")
    public ResponseEntity<Object> update(@Validated(ModDocs.Update.class) @RequestBody YqpcMain resources) {
        modYqpcMainService.save(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除文档")
    @ApiOperation("删除文档")
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("@el.check('pcdj:del')")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        modYqpcMainService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Log("删除文档")
    @ApiOperation("删除文档")
    @DeleteMapping
    @PreAuthorize("@el.check('pcdj:del')")
    public ResponseEntity<Object> delete(@RequestBody Long[] ids) {
        modYqpcMainService.deleteBatch(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
