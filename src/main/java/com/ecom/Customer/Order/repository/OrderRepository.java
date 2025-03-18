package com.ecom.Customer.Order.repository;
import com.ecom.Customer.Order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }