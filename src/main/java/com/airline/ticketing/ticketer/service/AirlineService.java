package com.airline.ticketing.ticketer.service;

import com.airline.ticketing.ticketer.data.Airline;
import com.airline.ticketing.ticketer.data.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AirlineService extends EntityService<Airline> {

    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public JpaRepository<Airline, Long> getRepository() {
        return airlineRepository;
    }

    @Override
    public Page<Airline> pageableSearch(Pageable pageable, String text) {
        return airlineRepository.findAllByNameContainsOrDescContains(text, text, pageable);
    }
}
