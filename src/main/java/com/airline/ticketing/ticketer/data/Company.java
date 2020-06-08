package com.airline.ticketing.ticketer.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "company")
@EqualsAndHashCode(callSuper = true)
public class Company extends BaseEntity {

}
