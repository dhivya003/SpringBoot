package com.ecom.customerorder.controller;

import com.ecom.customerorder.model.Customer;
import com.ecom.customerorder.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Tag(name = "Customer API", description = "Operations related to customers")
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")
    public Customer getCustomerById(@PathVariable Long customerId) {
        return service.getCustomerById(customerId);
    }


    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")


    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        service.createCustomer(customer);
        return ResponseEntity.ok("Customer saved successfully");
    }

    @DeleteMapping("/{customerId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")
    public void deleteCustomer(@PathVariable Long customerId) {
        service.deleteCustomer(customerId);
    }
}