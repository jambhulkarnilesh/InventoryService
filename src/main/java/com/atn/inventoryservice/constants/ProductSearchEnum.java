package com.atn.inventoryservice.constants;

public enum ProductSearchEnum {
    ALL("ALL"),
    PRODUCT_NAME("PRODUCT_NAME");
    private String searchBy;

    ProductSearchEnum(String searchBy) {
        this.searchBy = searchBy;
    }

    public String getSearchType() {
        return this.searchBy;
    }
}
