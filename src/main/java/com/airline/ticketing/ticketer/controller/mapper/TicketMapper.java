package com.airline.ticketing.ticketer.controller.mapper;

import com.airline.ticketing.ticketer.data.Ticket;
import com.airline.ticketing.ticketer.dto.TicketDto;
import com.airline.ticketing.ticketer.resource.TicketResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper extends EntityMapper<TicketDto, Ticket, TicketResource> {
}
