package com.airline.ticketing.ticketer.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TicketDto extends EntityDto {

    private Long flightId;

    private String cardNumber;

    private String number;
}
