package com.airline.ticketing.ticketer.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "airport")
@EqualsAndHashCode(callSuper = true)
public class Airport extends BaseEntity {

    @Column(nullable = false)
    private String city;
}