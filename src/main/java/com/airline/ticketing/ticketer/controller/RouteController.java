package com.airline.ticketing.ticketer.controller;

import com.airline.ticketing.ticketer.controller.mapper.EntityMapper;
import com.airline.ticketing.ticketer.controller.mapper.RouteMapper;
import com.airline.ticketing.ticketer.data.Route;
import com.airline.ticketing.ticketer.dto.RouteDto;
import com.airline.ticketing.ticketer.resource.RouteResource;
import com.airline.ticketing.ticketer.service.EntityService;
import com.airline.ticketing.ticketer.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController extends EntityController<RouteDto, Route, RouteResource>{

    @Autowired
    private RouteService routeService;

    @Autowired
    private RouteMapper routeMapper;

    @Override
    public EntityService<Route> getService() {
        return routeService;
    }

    @Override
    public EntityMapper<RouteDto, Route, RouteResource> getMapper() {
        return routeMapper;
    }
}

