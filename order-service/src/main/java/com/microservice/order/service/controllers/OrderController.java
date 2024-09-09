package com.microservice.order.service.controllers;

import com.microservice.order.service.dto.OrderRequest;
import com.microservice.order.service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest)
    {
        this.orderService.createOrder(orderRequest);
        return "Order is placed";
    }

}



















