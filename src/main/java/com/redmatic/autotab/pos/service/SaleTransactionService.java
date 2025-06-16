package com.redmatic.autotab.pos.service;

import com.redmatic.autotab.pos.dto.SaleTransactionRequest;
import com.redmatic.autotab.pos.dto.SaleTransactionResponse;

import java.util.List;

public interface SaleTransactionService {
    SaleTransactionResponse createSaleTransaction(SaleTransactionRequest request);
    List<SaleTransactionResponse> getAllSaleTransactions();
}