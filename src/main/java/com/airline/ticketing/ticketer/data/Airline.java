package com.airline.ticketing.ticketer.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "airline")
@EqualsAndHashCode(callSuper = true)
public class Airline extends BaseEntity {

    @Column
    private String city;
}