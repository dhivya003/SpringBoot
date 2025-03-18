package com.ecom.customerorder.service;



import com.ecom.customerorder.exception.ResourceNotFoundException;
import com.ecom.customerorder.model.Customer;
import com.ecom.customerorder.model.Product;
import com.ecom.customerorder.repository.CustomerRepository;
import com.ecom.customerorder.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
     CustomerRepository customerRepository;


    @Autowired
    ProductRepository productRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }

    public Customer createCustomer(Customer customer) {

        Customer newCustomer = new Customer();
        newCustomer.setName(customer.getName());
        newCustomer.setEmail(customer.getEmail());

        Customer savedCustomer = customerRepository.save(newCustomer);

        if (customer.getProduct() != null && !customer.getProduct().isEmpty()) {
            for (Product product : customer.getProduct()) {
                product.setCustomer(savedCustomer);
                productRepository.save(product);
            }
        }

        return savedCustomer;
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
