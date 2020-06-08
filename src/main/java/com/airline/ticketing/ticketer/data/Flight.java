package com.airline.ticketing.ticketer.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "flight")
@EqualsAndHashCode(callSuper = true)
public class Flight extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @Column
    private Date date;

    @Column
    private Integer capacity;

    @Column(nullable = false)
    private Double basePrice;
}
