package com.airline.ticketing.ticketer.service;

import com.airline.ticketing.ticketer.data.Flight;
import com.airline.ticketing.ticketer.data.Ticket;
import com.airline.ticketing.ticketer.data.repository.TicketRepository;
import com.airline.ticketing.ticketer.dto.TicketDto;
import com.airline.ticketing.ticketer.resource.PriceResource;
import com.airline.ticketing.ticketer.util.StringUtil;
import lombok.Synchronized;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService extends EntityService<Ticket> {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private FlightService flightService;

    @Synchronized
    public Ticket save(TicketDto dto) {
        Ticket ticket = new Ticket();

        PriceResource priceDetail = flightService.getPriceDetail(dto.getFlightId());
        ticket.setPrice(priceDetail.getCurrentPrice());
        if (priceDetail.getCurrentCapacity() >= priceDetail.getTotalCapacity()) {
            throw new RuntimeException("All seats are taken for this flight");
        }

        ticket.setFlight(flightService.getEntity(dto.getFlightId()));
        ticket.setCardNumber(StringUtil.formatCardNumber(dto.getCardNumber()));
        ticket.setName(dto.getName());
        ticket.setDesc(dto.getDesc());
        return save(ticket);
    }

    public Integer countByFlight(Flight flight) {
        return ticketRepository.countAllByFlight(flight);
    }

    public Page<Ticket> pageableByFlight(Pageable pageable, Long flightId) {
        Flight flight = flightService.getEntity(flightId);
        return ticketRepository.findAllByFlight(flight, pageable);
    }

    public Ticket findByNumber(Long flightId, String number) {
        if (StringUtils.isEmpty(number)) {
            throw new RuntimeException("Number must be declared");
        }
        Flight flight = flightService.getEntity(flightId);
        return ticketRepository.findTopByFlightAndNumber(flight, number);
    }

    public void deleteByNumber(Long flightId, String number) {
        Ticket ticket = findByNumber(flightId, number);
        getRepository().delete(ticket);
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
