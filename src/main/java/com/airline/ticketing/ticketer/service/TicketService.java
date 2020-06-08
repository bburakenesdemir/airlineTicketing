package com.airline.ticketing.ticketer.service;

import com.airline.ticketing.ticketer.data.Flight;
import com.airline.ticketing.ticketer.data.Ticket;
import com.airline.ticketing.ticketer.data.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService extends EntityService<Ticket> {

    @Autowired
    private TicketRepository ticketRepository;

    private Integer countByFlight(Flight flight) {
        return ticketRepository.countAllByFlight(flight);
    }

    @Override
    public JpaRepository<Ticket, Long> getRepository() {
        return ticketRepository;
    }

    @Override
    public Page<Ticket> pageableSearch(Pageable pageable, String text) {
        return ticketRepository.findAllByNameContainsOrDescContains(text, text, pageable);
    }
}
