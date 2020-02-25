package com.ratel.modules.system.service.mapper;

import com.ratel.framework.core.domain.BaseMapper;
import com.ratel.modules.system.domain.Dept;
import com.ratel.modules.system.service.dto.DeptDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptMapper extends BaseMapper<DeptDto, Dept> {

}
