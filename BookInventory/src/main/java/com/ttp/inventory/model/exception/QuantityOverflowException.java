package com.ttp.inventory.model.exception;

public class QuantityOverflowException extends Throwable {
    public QuantityOverflowException(String message) {
        super(message);
    }
}
