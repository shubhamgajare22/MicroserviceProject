package com.microservice.order.service.controllers;

import com.microservice.order.service.service.InvetryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inventry")
@RequiredArgsConstructor
public class InventryController {

    private final InvetryService invetryService;

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku-code") String skuCode) {
        return this.invetryService.isInStock(skuCode);
    }

}















