package com.redmatic.starterkit.pos.service;

import com.redmatic.starterkit.pos.dto.SaleTransactionRequest;
import com.redmatic.starterkit.pos.dto.SaleTransactionResponse;

import java.util.List;

public interface SaleTransactionService {
    SaleTransactionResponse createSaleTransaction(SaleTransactionRequest request);
    List<SaleTransactionResponse> getAllSaleTransactions();
}