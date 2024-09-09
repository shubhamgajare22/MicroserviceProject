package com.microservice.order.service;

import com.microservice.order.service.entities.Inventry;
import com.microservice.order.service.repo.InventryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class inventryService {

    public static void main(String[] args) {
        SpringApplication.run(inventryService.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventryRepo inventryRepo) {
        return supply -> {
            inventryRepo.save(Inventry.builder()
                    .skuCode("i phone_13")
                    .quantity(100).build());
            inventryRepo.save(Inventry.builder()
                    .skuCode("i phone_13 RED")
                    .quantity(0).build());
        };
    }
}
































