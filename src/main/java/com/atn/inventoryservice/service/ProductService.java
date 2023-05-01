package com.atn.inventoryservice.service;

import com.atn.inventoryservice.request.ProductRequest;
import com.atn.inventoryservice.response.ServiceResponse;

public interface ProductService {

    public ServiceResponse saveProduct(ProductRequest productRequest);
}
