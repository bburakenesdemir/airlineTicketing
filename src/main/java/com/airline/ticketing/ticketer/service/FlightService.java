package com.airline.ticketing.ticketer.service;

import com.airline.ticketing.ticketer.data.Flight;
import com.airline.ticketing.ticketer.data.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService extends EntityService<Flight> {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public JpaRepository<Flight, Long> getRepository() {
        return flightRepository;
    }

    @Override
    public Page<Flight> pageableSearch(Pageable pageable, String text) {
        return flightRepository.findAllByNameContainsOrDescContains(text, text, pageable);
    }
}
