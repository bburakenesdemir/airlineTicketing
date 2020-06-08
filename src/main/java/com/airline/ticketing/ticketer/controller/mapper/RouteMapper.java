package com.airline.ticketing.ticketer.controller.mapper;

import com.airline.ticketing.ticketer.data.Route;
import com.airline.ticketing.ticketer.dto.RouteDto;
import com.airline.ticketing.ticketer.resource.RouteResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RouteMapper extends EntityMapper<RouteDto, Route, RouteResource> {
}

