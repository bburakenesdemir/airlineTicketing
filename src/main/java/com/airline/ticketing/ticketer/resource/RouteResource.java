package com.airline.ticketing.ticketer.resource;

import lombok.Data;

@Data
public class RouteResource extends EntityResource {

    private AirportResource from;

    private AirportResource to;
}
