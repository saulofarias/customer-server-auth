package com.vempranuvem.customerserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vempranuvem.customerserver.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
