package com.productService.entities;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

//@Entity
@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "product_Table")
@Builder
@Getter
@Setter
public class Product {

    @Id
    private String id;

    private String productName;

    private String Description;

    private BigDecimal price;



}
























