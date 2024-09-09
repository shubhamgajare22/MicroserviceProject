package com.microservice.order.service.service.impl;

import com.microservice.order.service.repo.InventryRepo;
import com.microservice.order.service.service.InvetryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class InventryServiceImpl implements InvetryService {

    private final InventryRepo inventryRepo;

    @Override
    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {

        return inventryRepo.findBySkuCode(skuCode).isPresent();
    }
}





















