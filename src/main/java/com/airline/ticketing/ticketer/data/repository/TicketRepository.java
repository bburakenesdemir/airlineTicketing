package com.airline.ticketing.ticketer.data.repository;

import com.airline.ticketing.ticketer.data.Flight;
import com.airline.ticketing.ticketer.data.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Page<Ticket> findAllByNameContainsOrDescContains(String namePart, String DescPart, Pageable pageable);

    Integer countAllByFlight(Flight flight);
}
