package com.atn.inventoryservice.service;

import com.atn.inventoryservice.constants.ProductSearchEnum;
import com.atn.inventoryservice.constants.StatusCodeEnum;
import com.atn.inventoryservice.request.ProductRequest;
import com.atn.inventoryservice.request.UpdateProductStockRequest;
import com.atn.inventoryservice.response.ProductResponse;
import com.atn.inventoryservice.response.ServiceResponse;

import java.util.List;

public interface ProductService {

    public ServiceResponse saveProduct(ProductRequest productRequest);

    public ServiceResponse updateProductStocks(UpdateProductStockRequest productStockRequest);
    public List<ProductResponse> findProducts(ProductSearchEnum productSearchEnum, String searchString, StatusCodeEnum status_cd);
}
