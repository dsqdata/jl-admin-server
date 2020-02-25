package com.ratel.modules.msg.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.msg.domain.AccountMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMessageRepository extends BaseRepository<AccountMessage, Long> {

}
