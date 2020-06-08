package com.airline.ticketing.ticketer.controller;

import com.airline.ticketing.ticketer.controller.mapper.EntityMapper;
import com.airline.ticketing.ticketer.controller.mapper.TicketMapper;
import com.airline.ticketing.ticketer.data.Ticket;
import com.airline.ticketing.ticketer.dto.TicketDto;
import com.airline.ticketing.ticketer.resource.TicketResource;
import com.airline.ticketing.ticketer.service.EntityService;
import com.airline.ticketing.ticketer.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController extends EntityController<TicketDto, Ticket, TicketResource>{

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public EntityService<Ticket> getService() {
        return ticketService;
    }

    @Override
    public EntityMapper<TicketDto, Ticket, TicketResource> getMapper() {
        return ticketMapper;
    }
}
