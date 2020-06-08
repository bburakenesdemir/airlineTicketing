package com.airline.ticketing.ticketer.data.repository;

import com.airline.ticketing.ticketer.data.Airline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {

    Page<Airline> findAllByNameContainsOrDescContains(String namePart, String DescPart, Pageable pageable);

}
