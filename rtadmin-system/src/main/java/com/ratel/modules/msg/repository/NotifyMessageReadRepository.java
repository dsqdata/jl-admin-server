package com.ratel.modules.msg.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.msg.domain.NotifyMessage;
import com.ratel.modules.msg.domain.NotifyMessageRead;
import com.ratel.modules.system.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface NotifyMessageReadRepository extends BaseRepository<NotifyMessageRead, Long> {

    NotifyMessageRead findByNotifyMessageAndReadUser(NotifyMessage notifyMessage, User user);

    @Query("from NotifyMessageRead where readUser.id=:readUserId and notifyMessage.id in (:scopeEffectiveMessageIds)")
    @QueryHints({ @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true") })
    public List<NotifyMessageRead> findByReadUserAndNotifyMessageIn(@Param("readUserId") Long readUserId,
                                                                    @Param("scopeEffectiveMessageIds") List<Long> scopeEffectiveMessageIds);

    @Query("select count(nm) from NotifyMessageRead nm where nm.notifyMessage.id=:notifyMessageId")
    @QueryHints({ @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true") })
    Integer countByNotifyMessage(@Param("notifyMessageId") Long notifyMessageId);
}
