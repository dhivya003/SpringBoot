package com.ecom.Customer.Order.repository;
import com.ecom.Customer.Order.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> { }

