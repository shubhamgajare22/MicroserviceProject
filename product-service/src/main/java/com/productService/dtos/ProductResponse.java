package com.productService.dtos;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class ProductResponse {

    private String id;

    private String productName;

    private String Description;

    private BigDecimal price;


}























