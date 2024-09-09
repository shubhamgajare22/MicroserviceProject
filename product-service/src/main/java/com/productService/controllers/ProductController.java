package com.productService.controllers;

import com.productService.dtos.ProductRequest;
import com.productService.dtos.ProductResponse;
import com.productService.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor//this annotation is used for constructor injection.
public class ProductController {

    private final ProductServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        service.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        // service.getAllProducts();
        return this.service.getAllProducts();
    }

}















