package com.microservice.order.service.service;

import com.microservice.order.service.dto.OrderRequest;

public interface OrderService {

    void createOrder(OrderRequest orderRequest);
}
