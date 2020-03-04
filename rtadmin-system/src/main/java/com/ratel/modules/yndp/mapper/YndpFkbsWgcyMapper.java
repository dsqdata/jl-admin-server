package com.ratel.modules.yndp.mapper;

import com.ratel.modules.yndp.domain.YndpFkbsWgcy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author DDXS
 * @date 2020/3/3 22:24
 */
@Component
public interface YndpFkbsWgcyMapper {
    List<YndpFkbsWgcy> getWgcyList(String wgId);
}
