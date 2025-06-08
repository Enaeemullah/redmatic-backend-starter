package com.redmatic.starterkit.inventory.exception;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(int available, int requested) {
        super(String.format("Insufficient stock. Available: %d, Requested: %d", available, requested));
    }
}