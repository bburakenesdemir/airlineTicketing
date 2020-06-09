package com.airline.ticketing.ticketer.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "airport")
public class Airport extends BaseEntity {

    @Column(nullable = false)
    public String city;
}