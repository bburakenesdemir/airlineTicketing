package com.airline.ticketing.ticketer.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class FlightResource extends EntityResource {

    private CompanyResource companyResource;

    private RouteResource routeResource;

    private Date date;
}
