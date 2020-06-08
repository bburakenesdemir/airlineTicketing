package com.airline.ticketing.ticketer.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AirportResource extends EntityResource {

    private String city;
}
