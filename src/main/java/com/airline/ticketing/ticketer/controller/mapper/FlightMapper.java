package com.airline.ticketing.ticketer.controller.mapper;

import com.airline.ticketing.ticketer.data.Flight;
import com.airline.ticketing.ticketer.dto.FlightDto;
import com.airline.ticketing.ticketer.resource.FlightResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightMapper extends EntityMapper<FlightDto, Flight, FlightResource> {
}

