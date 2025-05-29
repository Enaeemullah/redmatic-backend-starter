package com.redmatic.starterkit.pos.service;

import com.redmatic.starterkit.pos.dto.SaleTransactionRequest;
import com.redmatic.starterkit.pos.dto.SaleTransactionResponse;
import com.redmatic.starterkit.pos.entity.SaleTransaction;
import com.redmatic.starterkit.pos.repository.SaleTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository saleTransactionRepository;

    @Override
    public SaleTransactionResponse createSaleTransaction(SaleTransactionRequest request) {
        SaleTransaction transaction = new SaleTransaction();
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setItemId(request.getItemId());
        transaction.setItemName(request.getItemName());
        transaction.setQuantity(request.getQuantity());
        transaction.setPrice(request.getPrice());
        transaction.setTotal(request.getTotal());
        transaction.setCreatedAt(LocalDateTime.now());
        transaction.setCustomerId(1L);

        saleTransactionRepository.save(transaction);

        return new SaleTransactionResponse(
                transaction.getTransactionId(),
                transaction.getItemId(),
                transaction.getItemName(),
                transaction.getQuantity(),
                transaction.getPrice(),
                transaction.getTotal(),
                transaction.getCreatedAt(),
                transaction.getCustomerId()
        );
    }

    @Override
    public List<SaleTransactionResponse> getAllSaleTransactions() {
        return saleTransactionRepository.findAll().stream()
                .map(t -> new SaleTransactionResponse(
                        t.getTransactionId(),
                        t.getItemId(),
                        t.getItemName(),
                        t.getQuantity(),
                        t.getPrice(),
                        t.getTotal(),
                        t.getCreatedAt(),
                        t.getCustomerId()
                ))
                .collect(Collectors.toList());
    }
}