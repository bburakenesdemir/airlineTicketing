package com.airline.ticketing.ticketer.dto;

import lombok.Data;

@Data
public class RouteDto extends EntityDto {

    private Long fromAirportId;

    private Long toAirportId;
}
