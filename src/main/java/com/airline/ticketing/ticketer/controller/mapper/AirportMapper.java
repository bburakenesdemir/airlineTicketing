package com.airline.ticketing.ticketer.controller.mapper;

import com.airline.ticketing.ticketer.data.Airport;
import com.airline.ticketing.ticketer.dto.AirportDto;
import com.airline.ticketing.ticketer.resource.AirportResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirportMapper extends EntityMapper<AirportDto, Airport, AirportResource> {
}
