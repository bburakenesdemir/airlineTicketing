package com.airline.ticketing.ticketer.service;

import com.airline.ticketing.ticketer.data.Airport;
import com.airline.ticketing.ticketer.data.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AirportService extends EntityService<Airport> {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public JpaRepository<Airport, Long> getRepository() {
        return airportRepository;
    }

    @Override
    public Page<Airport> pageableSearch(Pageable pageable, String text) {
        return airportRepository.findAllByNameContainsOrDescContains(text, text, pageable);
    }
}
