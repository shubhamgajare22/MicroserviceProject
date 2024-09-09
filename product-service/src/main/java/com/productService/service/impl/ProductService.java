package com.productService.service.impl;

import com.productService.dtos.ProductRequest;
import com.productService.dtos.ProductResponse;

import java.util.List;

public interface ProductService {

     void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();

}
