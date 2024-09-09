package com.productService.dtos;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class ProductRequest {

    private String productName;

    private String Description;

    private BigDecimal price;
}
