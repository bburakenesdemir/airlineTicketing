package com.airline.ticketing.ticketer.service;

import com.airline.ticketing.ticketer.data.Company;
import com.airline.ticketing.ticketer.data.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends EntityService<Company> {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public JpaRepository<Company, Long> getRepository() {
        return companyRepository;
    }

    @Override
    public Page<Company> pageableSearch(Pageable pageable, String text) {
        return companyRepository.findAllByNameContainsOrDescContains(text, text, pageable);
    }
}
