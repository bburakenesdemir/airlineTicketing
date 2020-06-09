package com.airline.ticketing.ticketer.dto;

import lombok.Data;

@Data
public class TicketDto extends EntityDto {

    private Long flightId;

    private String cardNumber;

    private String number;
}
