package com.microservice.order.service.service.impl;

import com.microservice.order.service.dto.OrderLineItemsDto;
import com.microservice.order.service.dto.OrderRequest;
import com.microservice.order.service.entities.Order;
import com.microservice.order.service.entities.OrderLineItems;
import com.microservice.order.service.repo.OrderRepo;
import com.microservice.order.service.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OderServiceImpl implements OrderService {

    // @Autowired
    private final OrderRepo orderRepo;
    private final WebClient webClient;

    @Override
    public void createOrder(OrderRequest orderRequest) {

        List<OrderLineItemsDto> orderLineItemsListDto = orderRequest.getOrderLineItemsListDto();

        List<OrderLineItems> OrderLineList = orderLineItemsListDto.stream()
                .map(this::mapToOrderLineItems)
                .toList();

        Order placedOrder = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderLineItemsList(OrderLineList)
                .build();
// call inventry service and place the order if product is in stock
        Boolean result =
                webClient.get()//GET request we are requesting to below URI
                .uri("http://localhost:9093/api/inventry")
                .retrieve()// this is for receive in response
                .bodyToMono(Boolean.class) //this is use for what respose we are getting
                .block(); //by default webclient uses Asynchronous request so we have to
                          // change that bydefault nature of webclient by using block();

        if (result) {
            this.orderRepo.save(placedOrder);
        } else {
            throw new IllegalArgumentException("product is out of Stock !! ");
        }
    }

    private OrderLineItems mapToOrderLineItems(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = OrderLineItems.builder()
                .price(orderLineItemsDto.getPrice())
                .quantity(orderLineItemsDto.getQuantity())
                .skuCode(orderLineItemsDto.getSkuCode())
                .build();

        return orderLineItems;
    }
}







