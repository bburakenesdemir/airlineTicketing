package com.airline.ticketing.ticketer.data;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "flight")
public class Flight extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    public Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    public Route route;

    @Column(nullable = false)
    public Date date;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private Double basePrice;
}
