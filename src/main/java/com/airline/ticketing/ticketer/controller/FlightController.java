package com.airline.ticketing.ticketer.controller;


import com.airline.ticketing.ticketer.controller.mapper.EntityMapper;
import com.airline.ticketing.ticketer.controller.mapper.FlightMapper;
import com.airline.ticketing.ticketer.data.Flight;
import com.airline.ticketing.ticketer.dto.FlightDto;
import com.airline.ticketing.ticketer.resource.FlightResource;
import com.airline.ticketing.ticketer.resource.PriceResource;
import com.airline.ticketing.ticketer.service.EntityService;
import com.airline.ticketing.ticketer.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight")
public class FlightController extends EntityController<FlightDto, Flight, FlightResource> {

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightMapper flightMapper;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<FlightResource> save(@RequestBody FlightDto dto) {
        FlightResource resource = getMapper().toResource(flightService.save(dto));
        resource.addLinks(getService().getTopicClass().getSimpleName().toLowerCase());
        return ResponseEntity.ok(resource);
    }

    @RequestMapping(value = "/{id}/price",method = RequestMethod.GET)
    public ResponseEntity<PriceResource> getPrice(@PathVariable("id") Long id) {
        return ResponseEntity.ok(flightService.getPriceDetail(id));
    }

    @RequestMapping(path = "/company/{companyId}", method = RequestMethod.GET)
    public ResponseEntity<Page<FlightResource>> search(@PathVariable("companyId") Long companyId,
                                                       @RequestParam(defaultValue = "0", required = false) Integer pageNo,
                                                       @RequestParam(defaultValue = "10", required = false) Integer pageSize,
                                                       @RequestParam(defaultValue = "id", required = false) String sortBy,
                                                       @RequestParam(defaultValue = "ASC", required = false) String direction) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.Direction.valueOf(direction), sortBy);
        return ResponseEntity.ok(
                flightService.pageableByCompany(pageable, companyId).map(
                        entity -> {
                            FlightResource resource = getMapper().toResource(entity);
                            resource.addLinks(getService().getTopicClass().getSimpleName().toLowerCase());
                            return resource;
                        }
                )
        );
    }

    @Override
    public EntityService<Flight> getService() {
        return flightService;
    }

    @Override
    public EntityMapper<FlightDto, Flight, FlightResource> getMapper() {
        return flightMapper;
    }
}
