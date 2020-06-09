package com.airline.ticketing.ticketer.resource;

import com.airline.ticketing.ticketer.data.Flight;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TicketResource extends EntityResource {

    private Flight flight;

    private String cardNumber;

    private Double price;

    private String number;
}
