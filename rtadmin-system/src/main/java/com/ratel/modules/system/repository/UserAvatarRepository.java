package com.ratel.modules.system.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.system.domain.UserAvatar;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAvatarRepository extends BaseRepository<UserAvatar, Long> {

}
