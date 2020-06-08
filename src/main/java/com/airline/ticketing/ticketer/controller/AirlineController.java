package com.airline.ticketing.ticketer.controller;

import com.airline.ticketing.ticketer.controller.mapper.AirlineMapper;
import com.airline.ticketing.ticketer.controller.mapper.EntityMapper;
import com.airline.ticketing.ticketer.data.Airline;
import com.airline.ticketing.ticketer.dto.AirlineDto;
import com.airline.ticketing.ticketer.resource.AirlineResource;
import com.airline.ticketing.ticketer.service.AirlineService;
import com.airline.ticketing.ticketer.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airline")
public class AirlineController extends EntityController<AirlineDto, Airline, AirlineResource>{

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AirlineMapper airlineMapper;

    @Override
    public EntityService<Airline> getService() {
        return airlineService;
    }

    @Override
    public EntityMapper<AirlineDto, Airline, AirlineResource> getMapper() {
        return airlineMapper;
    }
}
