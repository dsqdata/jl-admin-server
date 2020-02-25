package com.ratel.modules.system.service.mapper;

import com.ratel.framework.core.domain.BaseMapper;
import com.ratel.modules.system.domain.Role;
import com.ratel.modules.system.service.dto.RoleSmallDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleSmallMapper extends BaseMapper<RoleSmallDto, Role> {

}
