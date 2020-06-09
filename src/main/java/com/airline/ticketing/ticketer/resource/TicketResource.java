package com.airline.ticketing.ticketer.resource;

import com.airline.ticketing.ticketer.data.Flight;
import lombok.Data;

@Data
public class TicketResource extends EntityResource {

    private Flight flight;

    private String cardNumber;

    private Double price;

    private String number;
}
