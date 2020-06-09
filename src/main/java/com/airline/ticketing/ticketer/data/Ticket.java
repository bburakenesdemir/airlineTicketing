package com.airline.ticketing.ticketer.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ticket", uniqueConstraints={
        @UniqueConstraint(columnNames = {"flight_id", "number"})
})
public class Ticket extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", nullable = false)
    public Flight flight;

    @Column(name = "card_number")
    public String cardNumber;

    @Column(nullable = false)
    public Double price;

    @Column
    public String number;
}
