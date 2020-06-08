package com.airline.ticketing.ticketer.data.repository;

import com.airline.ticketing.ticketer.data.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Page<Flight> findAllByNameContainsOrDescContains(String namePart, String DescPart, Pageable pageable);
}
