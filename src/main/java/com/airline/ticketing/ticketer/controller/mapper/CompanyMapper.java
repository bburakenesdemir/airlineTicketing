package com.airline.ticketing.ticketer.controller.mapper;

import com.airline.ticketing.ticketer.data.Company;
import com.airline.ticketing.ticketer.dto.CompanyDto;
import com.airline.ticketing.ticketer.resource.CompanyResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends EntityMapper<CompanyDto, Company, CompanyResource> {

}