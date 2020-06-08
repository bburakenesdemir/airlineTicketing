package com.airline.ticketing.ticketer.controller.mapper;

import org.mapstruct.Mapper;

public interface EntityMapper<DTO, ENTITY, RESOURCE> {

    ENTITY toEntity(DTO dto);

    RESOURCE toResource(ENTITY entity);

}
