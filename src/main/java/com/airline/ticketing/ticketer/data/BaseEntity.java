package com.airline.ticketing.ticketer.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "last_update_date")
    private Date lastUpdateDate;

    @Column
    private String name;

    @Column
    private String desc;
}
