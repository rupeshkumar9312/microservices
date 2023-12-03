package com.tutorial.inventoryservice.service;

import com.tutorial.inventoryservice.dto.InventoryResponse;
import com.tutorial.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepository
                .findBySkuCodeIn(skuCode)
                .stream()
                .map(inventory -> InventoryResponse.builder().inStock(inventory.getQuantity() > 0).skuCode(inventory.getSkuCode()).build()).collect(Collectors.toList());
    }
}
