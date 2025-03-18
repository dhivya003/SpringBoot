package com.ecom.customerorder.controller;


import com.ecom.customerorder.model.Product;
import com.ecom.customerorder.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@Tag(name = "order API", description = "Operations related to order")
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAllOrders() {
        return productService.getAllProduct();
    }

    @GetMapping("/{productId}")
    public Product getOrderById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")

    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.ok("Product saved successfully");
    }

    @DeleteMapping("/{productId}")
    public void deleteOrder(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }
}
