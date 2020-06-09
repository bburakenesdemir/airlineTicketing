package com.airline.ticketing.ticketer.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class FlightDto extends EntityDto {

    private Long routeId;

    private Long companyId;

    private String dateStr;

    private Integer capacity;

    private Double basePrice;
}
