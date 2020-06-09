package com.airline.ticketing.ticketer.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ticket", uniqueConstraints={
        @UniqueConstraint(columnNames = {"flight_id", "number"})
})
public class Ticket extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(nullable = false)
    private Double price;

    @Column
    private String number;
}
