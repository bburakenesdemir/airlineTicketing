package com.airline.ticketing.ticketer.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "company")
public class Company extends BaseEntity {

}
