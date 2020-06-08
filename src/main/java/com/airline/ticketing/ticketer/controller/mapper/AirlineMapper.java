package com.airline.ticketing.ticketer.controller.mapper;

import com.airline.ticketing.ticketer.data.Airline;
import com.airline.ticketing.ticketer.dto.AirlineDto;
import com.airline.ticketing.ticketer.resource.AirlineResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirlineMapper extends EntityMapper<AirlineDto, Airline, AirlineResource> {
}
