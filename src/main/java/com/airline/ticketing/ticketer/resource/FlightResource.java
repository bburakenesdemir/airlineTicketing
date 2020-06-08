package com.airline.ticketing.ticketer.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class FlightResource extends EntityResource {

    private CompanyResource company;

    private RouteResource route;

    private Date date;

    private Integer capacity;
}
