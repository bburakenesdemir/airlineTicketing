package com.airline.ticketing.ticketer.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompanyDto extends EntityDto {

    private String name;

    private String desc;

}
