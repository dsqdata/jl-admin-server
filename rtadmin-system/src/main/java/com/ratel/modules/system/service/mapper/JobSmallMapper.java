package com.ratel.modules.system.service.mapper;

import com.ratel.framework.core.domain.BaseMapper;
import com.ratel.modules.system.domain.Job;
import com.ratel.modules.system.service.dto.JobSmallDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobSmallMapper extends BaseMapper<JobSmallDto, Job> {

}
