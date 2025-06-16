package com.redmatic.autotab.inventory.controller;

import com.redmatic.autotab.constants.ApiURI;
import com.redmatic.autotab.inventory.dto.StockTransferDTO;
import com.redmatic.autotab.inventory.dto.StockTransferResponse;
import com.redmatic.autotab.inventory.service.StockTransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiURI.API_BASE_PATH)
public class StockTransferController {

    private final StockTransferService transferService;

    public StockTransferController(StockTransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping(ApiURI.INVENTORY_STOCK_TRANSFER)
    public ResponseEntity<StockTransferResponse> transferStock(@RequestBody StockTransferDTO request) {
        return ResponseEntity.ok(transferService.transferStock(request));
    }
}
