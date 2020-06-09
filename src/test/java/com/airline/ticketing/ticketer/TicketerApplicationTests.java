package com.airline.ticketing.ticketer;

import com.airline.ticketing.ticketer.data.*;
import com.airline.ticketing.ticketer.data.repository.TicketRepository;
import com.airline.ticketing.ticketer.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest
class TicketerApplicationTests {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    void contextLoads() {
        Ticket ticket = new Ticket();
        ticket.setPrice(10.0);
        ticket.setCardNumber("1234123412341234");
        ticket.setName("test ticket name");

        Flight flight = new Flight();
        flight.setCapacity(100);
        flight.setName("test flight");

        Route route = new Route();
        route.setName("route test");

        Airport airport1 = new Airport();
        airport1.setName("airport test1");
        airport1.setCity("city test 1");
        airport1 = airportService.save(airport1);

        Airport airport2 = new Airport();
        airport2.setName("airport test2");
        airport2.setCity("city test 2");
        airport2 = airportService.save(airport2);

        route.setFrom(airport1);
        route.setTo(airport2);
        route = routeService.save(route);

        flight.setRoute(route);

        Company company = new Company();
        company.setName("company test");
        company = companyService.save(company);

        flight.setCompany(company);
        flight.setDate(Date.valueOf(LocalDate.now()));
        flight.setBasePrice(10.0);
        flight = flightService.save(flight);

        ticket.setFlight(flight);
        ticket.setPrice(15.0);
        ticket.setNumber("ab01");

        Ticket t = ticketService.save(ticket);

        // when
        Ticket found = ticketRepository.findById(t.getId()).get();
        assertThat(found).isNotNull();
    }

}
