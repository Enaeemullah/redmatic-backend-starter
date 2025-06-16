package com.redmatic.autotab.inventory.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long itemId, Long branchId) {
        super(String.format("Item %d not found in branch %d", itemId, branchId));
    }
}