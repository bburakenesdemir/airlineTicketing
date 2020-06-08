package com.airline.ticketing.ticketer.data.repository;

import com.airline.ticketing.ticketer.data.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
