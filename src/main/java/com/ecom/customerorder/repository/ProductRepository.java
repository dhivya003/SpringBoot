package com.ecom.customerorder.repository;
import com.ecom.customerorder.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { }