package com.airline.ticketing.ticketer.service;

import com.airline.ticketing.ticketer.data.Airport;
import com.airline.ticketing.ticketer.data.Company;
import com.airline.ticketing.ticketer.data.Flight;
import com.airline.ticketing.ticketer.data.Route;
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

    @PostConstruct
    public void init() {
        Company company = createCompany();
        Airport airport1 = createAirport("istanbul");
        Airport airport2 = createAirport("ankara");
        Route route = createRoute(airport1, airport2);
        Flight flight = createFlight(company, route);
        System.out.println(flight);
    }

    private Flight createFlight(Company company, Route route) {
        Flight flight = new Flight();
        flight.setName("test flight");
        flight.setDesc("test flight desc");
        flight.setDate(Date.valueOf(LocalDate.now()));
        flight.setCompany(company);
        flight.setRoute(route);
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
