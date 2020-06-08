package com.airline.ticketing.ticketer.service;

import com.airline.ticketing.ticketer.data.Route;
import com.airline.ticketing.ticketer.data.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RouteService extends EntityService<Route> {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public JpaRepository<Route, Long> getRepository() {
        return routeRepository;
    }

    @Override
    public Page<Route> pageableSearch(Pageable pageable, String text) {
        return routeRepository.findAllByNameContainsOrDescContains(text, text, pageable);
    }
}
