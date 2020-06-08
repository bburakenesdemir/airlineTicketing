package com.airline.ticketing.ticketer.controller;


import com.airline.ticketing.ticketer.controller.mapper.EntityMapper;
import com.airline.ticketing.ticketer.controller.mapper.FlightMapper;
import com.airline.ticketing.ticketer.data.Flight;
import com.airline.ticketing.ticketer.dto.FlightDto;
import com.airline.ticketing.ticketer.resource.FlightResource;
import com.airline.ticketing.ticketer.service.EntityService;
import com.airline.ticketing.ticketer.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class FlightController extends EntityController<FlightDto, Flight, FlightResource>{

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightMapper flightMapper;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<FlightResource> save(@RequestBody FlightDto dto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public EntityService<Flight> getService() {
        return flightService;
    }

    @Override
    public EntityMapper<FlightDto, Flight, FlightResource> getMapper() {
        return flightMapper;
    }
}
