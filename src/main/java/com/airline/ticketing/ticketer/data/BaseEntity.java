package com.airline.ticketing.ticketer.data;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
