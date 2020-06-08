package com.airline.ticketing.ticketer.controller;

import com.airline.ticketing.ticketer.controller.mapper.AirportMapper;
import com.airline.ticketing.ticketer.controller.mapper.EntityMapper;
import com.airline.ticketing.ticketer.data.Airport;
import com.airline.ticketing.ticketer.dto.AirportDto;
import com.airline.ticketing.ticketer.resource.AirportResource;
import com.airline.ticketing.ticketer.service.AirportService;
import com.airline.ticketing.ticketer.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airline")
public class AirportController extends EntityController<AirportDto, Airport, AirportResource>{

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirportMapper airportMapper;

    @Override
    public EntityService<Airport> getService() {
        return airportService;
    }

    @Override
    public EntityMapper<AirportDto, Airport, AirportResource> getMapper() {
        return airportMapper;
    }
}
