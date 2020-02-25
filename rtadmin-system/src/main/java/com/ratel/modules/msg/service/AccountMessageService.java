package com.ratel.modules.msg.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.framework.utils.DateUtils;
import com.ratel.framework.utils.FileUtil;
import com.ratel.framework.utils.PageUtil;
import com.ratel.framework.utils.QueryHelp;
import com.ratel.modules.mnt.websocket.MsgType;
import com.ratel.modules.mnt.websocket.SocketMsg;
import com.ratel.modules.mnt.websocket.WebSocketServer;
import com.ratel.modules.msg.domain.AccountMessage;
import com.ratel.modules.msg.repository.AccountMessageRepository;
import com.ratel.modules.msg.service.dto.AccountMessageQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AccountMessageService extends BaseService<AccountMessage, Long> {

    @Autowired
    private AccountMessageRepository accountMessageRepository;

    public Map<String, Object> queryAll(AccountMessageQueryCriteria modDocs, Pageable pageable) {
        Page<AccountMessage> page = accountMessageRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, modDocs, cb), pageable);
        return PageUtil.toPage(page);
    }

    public List<AccountMessage> queryAll(AccountMessageQueryCriteria dict) {
        List<AccountMessage> list = accountMessageRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, dict, cb));
        return list;
    }

    public void download(List<AccountMessage> dictDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (AccountMessage deptDTO : dictDtos) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("创建日期", deptDTO.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }

    public void processUserRead(AccountMessage entity) {
        if (entity.getFirstReadTime() == null) {
            entity.setFirstReadTime(DateUtils.currentDateTime());
            entity.setLastReadTime(entity.getFirstReadTime());
            entity.setReadTotalCount(1);
        } else {
            entity.setLastReadTime(DateUtils.currentDateTime());
            entity.setReadTotalCount(entity.getReadTotalCount() + 1);
        }
        accountMessageRepository.save(entity);
    }

}
