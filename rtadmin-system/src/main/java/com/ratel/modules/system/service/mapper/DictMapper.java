package com.ratel.modules.system.service.mapper;

import com.ratel.framework.core.domain.BaseMapper;
import com.ratel.modules.system.domain.Dict;
import com.ratel.modules.system.service.dto.DictDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends BaseMapper<DictDto, Dict> {

}
