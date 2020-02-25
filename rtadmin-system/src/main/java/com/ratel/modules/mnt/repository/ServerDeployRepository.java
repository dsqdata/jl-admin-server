package com.ratel.modules.mnt.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.mnt.domain.ServerDeploy;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerDeployRepository extends BaseRepository<ServerDeploy, Long> {

    /**
     * 根据IP查询
     *
     * @param ip /
     * @return /
     */
    ServerDeploy findByIp(String ip);
}
