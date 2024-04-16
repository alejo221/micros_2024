package com.msecxercise.inventoryservice.controller;

import com.msecxercise.inventoryservice.dto.InventoryResponse;
import com.msecxercise.inventoryservice.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    //http://localhost:8082/api/inventory?skuCode=Arepa
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) throws InterruptedException {
        log.info("Received inventory check request for skuCode: {}", skuCode);
        return inventoryService.isInStock(skuCode);
    }
}
