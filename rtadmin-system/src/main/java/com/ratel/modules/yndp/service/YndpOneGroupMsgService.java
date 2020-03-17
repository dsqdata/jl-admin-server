package com.ratel.modules.yndp.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.yndp.domain.YndpOneGroupMsg;
import com.ratel.modules.yndp.repository.YndpOneGroupMsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 第一屏-各小组信息Service
 * @author DDXS
 * @date 2020/3/17 16:15
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class YndpOneGroupMsgService extends BaseService<YndpOneGroupMsg, String> {
    @Autowired
    YndpOneGroupMsgRepository yndpOneGroupMsgRepository;

    public List<YndpOneGroupMsg> getGroupMsgByType(String type) {
        return yndpOneGroupMsgRepository.getGroupMsgByType(type);
    }
}
