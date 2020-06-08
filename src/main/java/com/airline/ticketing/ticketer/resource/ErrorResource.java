package com.airline.ticketing.ticketer.resource;

import lombok.Data;

@Data
public class ErrorResource {

    public int error_status;

    public String error_message;

    public String detail;
}
