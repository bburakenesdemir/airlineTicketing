package com.airline.ticketing.ticketer.controller;

import com.airline.ticketing.ticketer.controller.mapper.EntityMapper;
import com.airline.ticketing.ticketer.controller.mapper.RouteMapper;
import com.airline.ticketing.ticketer.data.Route;
import com.airline.ticketing.ticketer.dto.RouteDto;
import com.airline.ticketing.ticketer.resource.RouteResource;
import com.airline.ticketing.ticketer.service.EntityService;
import com.airline.ticketing.ticketer.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController extends EntityController<RouteDto, Route, RouteResource>{

    @Autowired
    private RouteService routeService;

    @Autowired
    private RouteMapper routeMapper;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<RouteResource> save(@RequestBody RouteDto dto) {
        RouteResource resource = getMapper().toResource(routeService.save(dto));
        resource.addLinks(getService().getTopicClass().getSimpleName().toLowerCase());
        return ResponseEntity.ok(resource);
    }

    @Override
    public EntityService<Route> getService() {
        return routeService;
    }

    @Override
    public EntityMapper<RouteDto, Route, RouteResource> getMapper() {
        return routeMapper;
    }
}

