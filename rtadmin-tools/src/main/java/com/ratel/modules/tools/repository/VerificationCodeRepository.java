package com.ratel.modules.tools.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.tools.domain.VerificationCode;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationCodeRepository extends BaseRepository<VerificationCode, Long> {

    /**
     * 获取有效的验证码
     *
     * @param scenes 业务场景，如重置密码，重置邮箱等等
     * @param type   类型
     * @param value  值
     * @return VerificationCode
     */
    VerificationCode findByScenesAndTypeAndValueAndStatusIsTrue(String scenes, String type, String value);
}
