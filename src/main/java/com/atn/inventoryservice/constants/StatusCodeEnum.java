package com.atn.inventoryservice.constants;

public enum StatusCodeEnum {
    ALL("ALL"),
    ACTIVE("A"),
    INACTIVE("I");
    private String statusCode;

    StatusCodeEnum(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return this.statusCode;
    }
}
