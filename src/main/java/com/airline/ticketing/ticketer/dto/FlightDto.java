package com.airline.ticketing.ticketer.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FlightDto extends EntityDto {

    private Long routeId;

    private Long companyId;

    private String dateStr;
}
