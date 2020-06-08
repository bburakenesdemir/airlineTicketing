package com.airline.ticketing.ticketer.service;

import com.airline.ticketing.ticketer.data.Company;
import com.airline.ticketing.ticketer.data.Flight;
import com.airline.ticketing.ticketer.data.repository.FlightRepository;
import com.airline.ticketing.ticketer.dto.FlightDto;
import com.airline.ticketing.ticketer.resource.PriceResource;
import com.airline.ticketing.ticketer.util.DateUtil;
import com.airline.ticketing.ticketer.util.PriceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService extends EntityService<Flight> {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private TicketService ticketService;

    @Override
    public JpaRepository<Flight, Long> getRepository() {
        return flightRepository;
    }

    public PriceResource getPriceDetail(Long id) {
        Flight flight = getEntity(id);
        Integer ticketCount = ticketService.countByFlight(flight);
        return PriceUtil.calculateCurrentPrice(flight, ticketCount);
    }

    public Flight save(FlightDto dto) {
        Flight flight = new Flight();
        flight.setCompany(companyService.getEntity(dto.getCompanyId()));
        flight.setRoute(routeService.getEntity(dto.getRouteId()));
        flight.setDate(DateUtil.toFlightDate(dto.getDateStr()));
        flight.setName(dto.getName());
        flight.setDesc(dto.getDesc());
        flight.setCapacity(dto.getCapacity());
        flight.setPrice(dto.getPrice());

        return save(flight);
    }

    @Override
    public Page<Flight> pageableSearch(Pageable pageable, String text) {
        return flightRepository.findAllByNameContainsOrDescContains(text, text, pageable);
    }

    public Page<Flight> pageableByCompany(Pageable pageable, Long companyId) {
        Company company = companyService.getEntity(companyId);
        return flightRepository.findAllByCompany(company, pageable);
    }
}
