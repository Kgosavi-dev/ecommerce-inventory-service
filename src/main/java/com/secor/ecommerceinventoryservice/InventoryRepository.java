package com.secor.ecommerceinventoryservice;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface InventoryRepository extends MongoRepository<Inventory, String> {
}
