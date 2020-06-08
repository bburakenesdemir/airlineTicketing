package com.airline.ticketing.ticketer.controller;

import com.airline.ticketing.ticketer.controller.mapper.CompanyMapper;
import com.airline.ticketing.ticketer.controller.mapper.EntityMapper;
import com.airline.ticketing.ticketer.data.Company;
import com.airline.ticketing.ticketer.dto.CompanyDto;
import com.airline.ticketing.ticketer.resource.CompanyResource;
import com.airline.ticketing.ticketer.service.CompanyService;
import com.airline.ticketing.ticketer.service.EntityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@Api("Airline Ticketer - Company Api")
public class CompanyController extends EntityController<CompanyDto, Company, CompanyResource>{

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public EntityService<Company> getService() {
        return companyService;
    }

    @Override
    public EntityMapper<CompanyDto, Company, CompanyResource> getMapper() {
        return companyMapper;
    }
}
