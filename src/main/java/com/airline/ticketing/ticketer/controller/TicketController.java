package com.airline.ticketing.ticketer.controller;

import com.airline.ticketing.ticketer.controller.mapper.EntityMapper;
import com.airline.ticketing.ticketer.controller.mapper.TicketMapper;
import com.airline.ticketing.ticketer.data.Ticket;
import com.airline.ticketing.ticketer.dto.TicketDto;
import com.airline.ticketing.ticketer.resource.TicketResource;
import com.airline.ticketing.ticketer.service.EntityService;
import com.airline.ticketing.ticketer.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController extends EntityController<TicketDto, Ticket, TicketResource> {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketMapper ticketMapper;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TicketResource> save(@RequestBody TicketDto dto) {
        return ResponseEntity.ok(ticketMapper.toResource(ticketService.save(dto)));
    }

    @RequestMapping(path = "/flight/{flightId}/number/{number}", method = RequestMethod.GET)
    public ResponseEntity<TicketResource> getByNumber(@PathVariable("flightId") Long flightId,
                                                      @PathVariable("number") String number) {
        return ResponseEntity.ok(ticketMapper.toResource(ticketService.findByNumber(flightId, number)));
    }

    @RequestMapping(path = "/flight/{flightId}/number/{number}", method = RequestMethod.DELETE)
    public ResponseEntity deleteByNumber(@PathVariable("flightId") Long flightId,
                                         @PathVariable("number") String number) {
        ticketService.deleteByNumber(flightId, number);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(path = "/flight/{flightId}", method = RequestMethod.GET)
    public ResponseEntity<Page<TicketResource>> search(@PathVariable("flightId") Long flightId,
                                                       @RequestParam(defaultValue = "0", required = false) Integer pageNo,
                                                       @RequestParam(defaultValue = "10", required = false) Integer pageSize,
                                                       @RequestParam(defaultValue = "id", required = false) String sortBy,
                                                       @RequestParam(defaultValue = "ASC", required = false) String direction) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.Direction.valueOf(direction), sortBy);
        return ResponseEntity.ok(
                ticketService.pageableByFlight(pageable, flightId).map(
                        entity -> {
                            TicketResource resource = getMapper().toResource(entity);
                            resource.addLinks(getService().getTopicClass().getSimpleName().toLowerCase());
                            return resource;
                        }
                )
        );
    }

    @Override
    public EntityService<Ticket> getService() {
        return ticketService;
    }

    @Override
    public EntityMapper<TicketDto, Ticket, TicketResource> getMapper() {
        return ticketMapper;
    }
}
