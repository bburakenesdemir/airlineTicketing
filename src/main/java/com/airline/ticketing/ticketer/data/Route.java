package com.airline.ticketing.ticketer.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "route")
@EqualsAndHashCode(callSuper = true)
public class Route extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_from", nullable = false)
    private Airport from;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_to", nullable = false)
    private Airport to;

}