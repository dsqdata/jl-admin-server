package com.ratel.modules.monitor.service;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.monitor.domain.Server;
import com.ratel.modules.monitor.repository.ServerRepository;
import com.ratel.modules.monitor.service.dto.ServerQueryCriteria;
import com.ratel.framework.utils.PageUtil;
import com.ratel.framework.utils.QueryHelp;
import com.ratel.framework.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ServerService extends BaseService<Server, Integer> {

    @Autowired
    private ServerRepository serverRepository;

    public Map<String, Object> queryAll(ServerQueryCriteria criteria, Pageable pageable) {
        Page<Server> page = serverRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        page.forEach(server -> {
            try {
                server.setState("1");
                String url = String.format("http://%s:%d/api/serverMonitor", server.getAddress(), server.getPort());
                String res = HttpUtil.get(url, 1000);
                JSONObject obj = JSONObject.parseObject(res);
                server.setCpuRate(obj.getDouble("cpuRate"));
                server.setCpuCore(obj.getInteger("cpuCore"));
                server.setMemTotal(obj.getDouble("memTotal"));
                server.setMemUsed(obj.getDouble("memUsed"));
                server.setDiskTotal(obj.getDouble("diskTotal"));
                server.setDiskUsed(obj.getDouble("diskUsed"));
                server.setSwapTotal(obj.getDouble("swapTotal"));
                server.setSwapUsed(obj.getDouble("swapUsed"));
            } catch (Exception e) {
                server.setState("0");
                e.printStackTrace();
            }
        });

        return PageUtil.toPage(page);
    }

    public List<Server> queryAll(ServerQueryCriteria criteria) {
        return serverRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder));
    }

    public Server findById(Integer id) {
        Server server = serverRepository.findById(id).orElseGet(Server::new);
        ValidationUtil.isNull(server.getId(), "Server", "id", id);
        return server;
    }

    @Transactional(rollbackFor = Exception.class)
    public Server create(Server resources) {
        return serverRepository.save(resources);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(Server resources) {
        Server server = serverRepository.findById(resources.getId()).orElseGet(Server::new);
        ValidationUtil.isNull(server.getId(), "Server", "id", resources.getId());
        server.copy(resources);
        serverRepository.save(server);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Integer> ids) {
        for (Integer id : ids) {
            serverRepository.deleteById(id);
        }
    }

}
