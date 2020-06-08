package com.airline.ticketing.ticketer.controller.mapper;

public interface EntityMapper<DTO, ENTITY, RESOURCE> {

    ENTITY toEntity(DTO dto);

    RESOURCE toResource(ENTITY entity);

}
