package com.airline.ticketing.ticketer.repository;

import com.airline.ticketing.ticketer.data.*;
import com.airline.ticketing.ticketer.data.repository.TicketRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TicketRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    public void whenFindByName_thenReturnTicket() {
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
        airport1 = entityManager.persist(airport1);

        Airport airport2 = new Airport();
        airport2.setName("airport test2");
        airport2.setCity("city test 2");
        airport2 = entityManager.persist(airport2);

        route.setFrom(airport1);
        route.setTo(airport2);
        route = entityManager.persist(route);

        flight.setRoute(route);

        Company company = new Company();
        company.setName("company test");
        company = entityManager.persist(company);

        flight.setCompany(company);
        flight.setDate(Date.valueOf(LocalDate.now()));
        flight.setBasePrice(10.0);
        flight = entityManager.persist(flight);

        ticket.setFlight(flight);
        ticket.setPrice(15.0);
        ticket.setNumber("ab01");

        Ticket t = entityManager.persist(ticket);
        entityManager.flush();

        // when
        Ticket found = ticketRepository.findById(t.getId()).get();
    }
}
