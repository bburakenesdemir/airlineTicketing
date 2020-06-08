package com.airline.ticketing.ticketer.resource;

import lombok.Data;

@Data
public class PriceResource {

    private Integer totalCapacity;

    private Integer currentCapacity;

    private Double basePrice;

    private Double currentPrice;
}
