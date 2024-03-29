package com.example.warehouse_management.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotFoundGlobalException extends RuntimeException {
    private String message;
}
