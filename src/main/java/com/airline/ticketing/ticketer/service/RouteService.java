package com.airline.ticketing.ticketer.service;

import com.airline.ticketing.ticketer.data.Route;
import com.airline.ticketing.ticketer.data.repository.RouteRepository;
import com.airline.ticketing.ticketer.dto.RouteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RouteService extends EntityService<Route> {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private AirportService airportService;

    @Override
    public JpaRepository<Route, Long> getRepository() {
        return routeRepository;
    }

    public Route save(RouteDto dto) {
        Route route = new Route();
        route.setFrom(airportService.getEntity(dto.getFromAirportId()));
        route.setTo(airportService.getEntity(dto.getToAirportId()));
        route.setName(dto.getName());
        route.setDesc(dto.getDesc());
        return save(route);
    }

    @Override
    public Page<Route> pageableSearch(Pageable pageable, String text) {
        return routeRepository.findAllByNameContainsOrDescContains(text, text, pageable);
    }
}
