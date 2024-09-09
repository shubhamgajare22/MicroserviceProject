package com.productService.service.impl;

import com.productService.dtos.ProductRequest;
import com.productService.dtos.ProductResponse;
import com.productService.entities.Product;
import com.productService.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j //Causes lombok to generate a logger field.
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    // private Logger logger= LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

//    ProductServiceImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product =
                Product.builder()
                        .productName(productRequest.getProductName())
                        .price(productRequest.getPrice())
                        .Description(productRequest.getDescription())
                        .build();

        productRepository.save(product);
        log.info("Product is saved {} :", product.getId());
        //{} --> its a place holder
        //it will dynamically get product id and replace with placeHolder
    }

    @Override
    public List<ProductResponse> getAllProducts() {

        List<Product> allProducts = this.productRepository.findAll();
        //  List<ProductResponse> productResponseList = allProducts.stream().map(product -> maptoProductResponse(product)).toList();

        List<ProductResponse> productResponseList = allProducts.stream().map(this::maptoProductResponse).toList();
        return productResponseList;
    }

    private ProductResponse maptoProductResponse(Product product) {
        return ProductResponse.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .Description(product.getDescription())
                .id(product.getId())
                .build();
    }

}












