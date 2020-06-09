package com.airline.ticketing.ticketer.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "route")
public class Route extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_from", nullable = false)
    public Airport from;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_to", nullable = false)
    public Airport to;

}