package com.ratel.modules.msg.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.msg.domain.NotifyMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface NotifyMessageRepository extends BaseRepository<NotifyMessage, Long> {

    @Query("from NotifyMessage where effective=true order by orderRank desc,publishTime desc")
    @QueryHints({ @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true") })
    public List<NotifyMessage> findEffectiveMessages();

    @Query("from NotifyMessage where effective=true and authRequired=false order by orderRank desc,publishTime desc")
    @QueryHints({ @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true") })
    public List<NotifyMessage> findEffectivePubMessages();

    @Query("from NotifyMessage where (effective is null or (effective=true and expireTime is not null))")
    @QueryHints({ @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true") })
    public List<NotifyMessage> findTobeEffectiveMessages();
}
