package com.airline.ticketing.ticketer.dto;

import lombok.Data;

@Data
public class FlightDto extends EntityDto {

    private Long routeId;

    private Long companyId;

    private String dateStr;

    private Integer capacity;

    private Double basePrice;
}
