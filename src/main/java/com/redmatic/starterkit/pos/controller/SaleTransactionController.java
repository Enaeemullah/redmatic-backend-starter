package com.redmatic.starterkit.pos.controller;

import com.redmatic.starterkit.pos.dto.SaleTransactionRequest;
import com.redmatic.starterkit.pos.dto.SaleTransactionResponse;
import com.redmatic.starterkit.pos.service.SaleTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pos")
@RequiredArgsConstructor
public class SaleTransactionController {

    private final SaleTransactionService saleTransactionService;

    @PostMapping("/sales")
    public ResponseEntity<SaleTransactionResponse> createSale(@RequestBody SaleTransactionRequest request) {
        return ResponseEntity.ok(saleTransactionService.createSaleTransaction(request));
    }

    @GetMapping("/sales")
    public ResponseEntity<List<SaleTransactionResponse>> getAllSales() {
        return ResponseEntity.ok(saleTransactionService.getAllSaleTransactions());
    }
}
