package com.microservice.order.service.repo;

import com.microservice.order.service.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo  extends JpaRepository<Order,Long> {

}
