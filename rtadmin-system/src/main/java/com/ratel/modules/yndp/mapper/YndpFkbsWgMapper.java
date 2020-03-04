package com.ratel.modules.yndp.mapper;

import com.ratel.modules.yndp.domain.YndpFkbsWg;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author DDXS
 * @date 2020/3/3 22:32
 */
@Component
public interface YndpFkbsWgMapper {
    List<YndpFkbsWg> getWgList(String jgId);
}
