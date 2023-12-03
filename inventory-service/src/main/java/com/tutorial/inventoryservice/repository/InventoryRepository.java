package com.tutorial.inventoryservice.repository;

import com.tutorial.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    public Optional <Inventory> findBySkuCodeIn(List<String> skuCode);

}
