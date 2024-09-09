package com.microservice.order.service.repo;

import com.microservice.order.service.entities.Inventry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventryRepo extends JpaRepository<Inventry,Long> {

    Optional<Inventry> findBySkuCode(String skuCode);
}
