package com.airline.ticketing.ticketer.data;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "creation_date")
    public Date creationDate;

    @Column(name = "last_update_date")
    public Date lastUpdateDate;

    @Column(nullable = false)
    public String name;

    @Column
    public String desc;
}
