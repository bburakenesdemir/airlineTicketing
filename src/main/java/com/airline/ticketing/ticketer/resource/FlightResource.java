package com.airline.ticketing.ticketer.resource;

import lombok.Data;

import java.sql.Date;

@Data
public class FlightResource extends EntityResource {

    private CompanyResource company;

    private RouteResource route;

    private Date date;

    private Integer capacity;

    private Double basePrice;
}
