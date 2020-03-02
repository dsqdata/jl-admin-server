package com.ratel.modules.msg.rest;

import com.ratel.config.DataScope;
import com.ratel.framework.exception.BadRequestException;
import com.ratel.framework.security.vo.JwtUser;
import com.ratel.modules.logging.aop.log.Log;
import com.ratel.modules.mnt.websocket.MsgType;
import com.ratel.modules.mnt.websocket.SocketMsg;
import com.ratel.modules.mnt.websocket.WebSocketServer;
import com.ratel.modules.msg.domain.AccountMessage;
import com.ratel.modules.msg.service.AccountMessageService;
import com.ratel.modules.msg.service.dto.AccountMessageQueryCriteria;
import com.ratel.modules.system.domain.User;
import com.ratel.modules.system.service.DeptService;
import com.ratel.modules.system.service.UserService;
import com.ratel.modules.system.service.dto.UserDto;
import com.ratel.modules.system.service.dto.UserQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api/maccountMessage")
@Api(tags = "信息：账号消息管理")
public class ManagerAccountMessageController {

    @Autowired
    private AccountMessageService accountMessageService;

    @Autowired
    private UserService userService;

    @Autowired
    private DataScope dataScope;

    @Autowired
    private DeptService deptService;

    private static final String ENTITY_NAME = "accountMessage";

    @Log("导出账号消息")
    @ApiOperation("导出账号消息")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('maccountmsg:list')")
    public void download(HttpServletResponse response, AccountMessageQueryCriteria criteria) throws IOException {
        accountMessageService.download(accountMessageService.queryAll(criteria), response);
    }


    @Log("查询账号消息")
    @ApiOperation("查询账号消息")
    @GetMapping
    @PreAuthorize("@el.check('maccountmsg:list')")
    public ResponseEntity<Object> getAccountMessage(AccountMessageQueryCriteria resources, Pageable pageable) {
        JwtUser jwtUser = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        resources.setCreateAccountId(jwtUser.getId());
        return new ResponseEntity<>(accountMessageService.queryAll(resources, pageable), HttpStatus.OK);
    }


    @Log("查询账号消息")
    @ApiOperation("查询账号消息")
    @GetMapping(value = "/getAccountMessageById/{id}")
    @PreAuthorize("@el.check('maccountmsg:list')")
    public ResponseEntity<Object> getAccountMessageById(@PathVariable Long id) {
        return new ResponseEntity<>(accountMessageService.findOne(id), HttpStatus.OK);
    }


    @Log("新增账号消息")
    @ApiOperation("新增账号消息")
    @PostMapping
    @PreAuthorize("@el.check('maccountmsg:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody AccountMessage resources) throws IOException {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        resources.setPublishTime(new Date());
        String batchNo = UUID.randomUUID().toString();

        if ("dept".equals(resources.getType())) {
//            UserQueryCriteria criteria = new UserQueryCriteria();
//            criteria.setDeptIds(resources.getTargetDepts());
//            List<UserDto> list = userService.queryAll(criteria);
//            for (UserDto userDto : list) {
//                AccountMessage accountMessage = new AccountMessage();
//                accountMessage.copy(resources);
//                User user = new User();
//                user.setId(userDto.getId());
//                accountMessage.setTargetAccount(user);
//                accountMessage.setBatchNo(batchNo);
//                accountMessageService.save(accountMessage);
//                WebSocketServer.sendInfoToSid(new SocketMsg(accountMessage.getTitle(), MsgType.INFO), user.getId() + "");
//            }
            UserQueryCriteria criteria = new UserQueryCriteria();

            List<UserDto> list = null;
            Set<Long> deptSet = new HashSet<>();
            Set<Long> result = new HashSet<>();

            for (Long deptId : resources.getTargetDepts()) {
                deptSet.add(deptId);
                deptSet.addAll(dataScope.getDeptChildren(deptService.findByPid(deptId)));

            }
            // 数据权限
            Set<Long> deptIds = dataScope.getDeptIds();
            // 查询条件不为空并且数据权限不为空则取交集
            if (!CollectionUtils.isEmpty(deptIds) && !CollectionUtils.isEmpty(deptSet)) {
                // 取交集
                result.addAll(deptSet);
                result.retainAll(deptIds);
                // 若无交集，则代表无数据权限
                criteria.setDeptIds(result);
                if (result.size() == 0) {
                    list = new ArrayList<>();
                } else {
                    list = userService.queryAll(criteria);
                }
                // 否则取并集
            } else {
                result.addAll(deptSet);
                result.addAll(deptIds);
                criteria.setDeptIds(result);
                list = userService.queryAll(criteria);
            }

            for (UserDto userDto : list) {
                AccountMessage accountMessage = new AccountMessage();
                accountMessage.copy(resources);
                User user = new User();
                user.setId(userDto.getId());
                accountMessage.setTargetAccount(user);
                accountMessage.setBatchNo(batchNo);
                accountMessageService.save(accountMessage);
                WebSocketServer.sendInfoToSid(new SocketMsg(accountMessage.getTitle(), MsgType.INFO), user.getId() + "");
            }
        } else {
            if (resources.getTargetAccounts() != null) {
                for (List<Long> list : resources.getTargetAccounts()) {
                    AccountMessage accountMessage = new AccountMessage();
                    accountMessage.copy(resources);
                    User user = new User();
                    user.setId(list.get(list.size() - 1));
                    accountMessage.setTargetAccount(user);
                    accountMessage.setBatchNo(batchNo);
                    accountMessageService.save(accountMessage);
                    WebSocketServer.sendInfoToSid(new SocketMsg(accountMessage.getTitle(), MsgType.INFO), user.getId() + "");
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Log("修改账号消息")
    @ApiOperation("修改账号消息")
    @PutMapping
    @PreAuthorize("@el.check('maccountmsg:edit')")
    public ResponseEntity<Object> update(@Validated(AccountMessage.Update.class) @RequestBody AccountMessage resources) {
        accountMessageService.save(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除账号消息")
    @ApiOperation("删除账号消息")
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("@el.check('maccountmsg:del')")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        accountMessageService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Log("删除账号消息")
    @ApiOperation("删除账号消息")
    @DeleteMapping
    @PreAuthorize("@el.check('maccountmsg:del')")
    public ResponseEntity<Object> delete(@RequestBody Long[] ids) {
        accountMessageService.deleteBatch(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Log("个人消息读取")
    @ApiOperation("个人消息读取")
    @PreAuthorize("@el.check('maccountmsg:del')")
    @GetMapping(value = "/accountMessageView/{messageId}")
    public ResponseEntity<Object> accountMessageView(@PathVariable Long messageId) {
        AccountMessage one = accountMessageService.findOne(messageId);
        accountMessageService.processUserRead(one);
        return new ResponseEntity<>(one, HttpStatus.OK);
    }
}
