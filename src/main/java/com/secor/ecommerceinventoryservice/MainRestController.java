package com.secor.ecommerceinventoryservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("api/v1")
public class MainRestController {

    private static final Logger log = LoggerFactory.getLogger(MainRestController.class);

    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    AuthService authService;


    @PostMapping("create/inventory")
    public ResponseEntity<?> createInventory(@RequestBody Inventory inventory,
                                           @RequestHeader("Authorization") String token)
    {
        log.info("Received request to create inventory: {}", inventory);
        if(!authService.validateToken(token))
        {
            log.info("Invalid token: {}", token);
            return ResponseEntity.badRequest().body("Invalid token");
        }
        log.info("Token is valid: {}", token);
        log.info("Saving inventory: {}", inventory);

        inventory.setInventoryid(String.valueOf(new Random().nextInt(1000)));
        inventoryRepository.save(inventory);

        return ResponseEntity.ok("Inventory created successfully");
    }

}
