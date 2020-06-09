package com.airline.ticketing.ticketer.service;

import com.airline.ticketing.ticketer.data.*;
import com.airline.ticketing.ticketer.util.PriceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.time.LocalDate;

@Service
public class InitService {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private TicketService ticketService;

    @PostConstruct
    public void init() {
        Company company = createCompany();
        Airport airport1 = createAirport("istanbul");
        Airport airport2 = createAirport("ankara");
        Route route = createRoute(airport1, airport2);
        Flight flight = createFlight(company, route, 40);
        System.out.println(flight);

        for (int i = 1; i <= 40; i++) {
            createTicket(flight, i);
        }
    }

    private Ticket createTicket(Flight flight, int index) {
        Ticket ticket = new Ticket();
        ticket.setCardNumber("1234");
        ticket.setFlight(flight);
        ticket.setName("ticket" + index);
        ticket.setDesc("ticket" + index + " desc");

        Integer ticketCount = ticketService.countByFlight(flight);
        ticket.setPrice(PriceUtil.calculateCurrentPrice(flight, ticketCount).getCurrentPrice());
        return ticketService.save(ticket);
    }

    private Flight createFlight(Company company, Route route, Integer capacity) {
        Flight flight = new Flight();
        flight.setName("test flight");
        flight.setDesc("test flight desc");
        flight.setDate(Date.valueOf(LocalDate.now()));
        flight.setCompany(company);
        flight.setRoute(route);
        flight.setCapacity(capacity);
        flight.setBasePrice(60.0);
        return flightService.save(flight);
    }

    private Route createRoute(Airport from, Airport to) {
        Route route = new Route();
        route.setFrom(from);
        route.setTo(to);
        route.setName("test route");
        route.setDesc("test route desc");
        return routeService.save(route);
    }

    private Airport createAirport(String city) {
        Airport airport = new Airport();
        airport.setCity(city);
        airport.setName(city + " airport");
        airport.setDesc(city + " airport desc");
        return airportService.save(airport);
    }

    private Company createCompany() {
        Company dto = new Company();
        dto.setName("test Company");
        dto.setDesc("test Company Desc");
        return companyService.save(dto);
    }
}
