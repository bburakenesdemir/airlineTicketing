package com.airline.ticketing.ticketer.resource;

import lombok.Data;

@Data
public class ErrorResource {

    private int error_status;

    private String error_message;

    private String detail;
}
