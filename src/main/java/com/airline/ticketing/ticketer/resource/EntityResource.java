package com.airline.ticketing.ticketer.resource;

import lombok.Data;

import java.sql.Date;

@Data
public class EntityResource {

    public Long id;

    public Date creationDate;

    public Date lastUpdateDate;

}
