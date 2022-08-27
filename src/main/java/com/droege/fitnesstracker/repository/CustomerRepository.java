package com.droege.fitnesstracker.repository;

import com.droege.fitnesstracker.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
