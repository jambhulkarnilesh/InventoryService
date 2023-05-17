package com.atn.inventoryservice.service;

import com.atn.inventoryservice.constants.ProductSearchEnum;
import com.atn.inventoryservice.constants.StatusCodeEnum;
import com.atn.inventoryservice.request.ProductRequest;
import com.atn.inventoryservice.request.UpdateProductStockRequest;
import com.atn.inventoryservice.response.ProductResponse;
import com.atn.inventoryservice.response.ServiceResponse;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    public ServiceResponse saveProduct(ProductRequest productRequest);

    public ServiceResponse updateProductStocks(UpdateProductStockRequest productStockRequest);

    public PageImpl<ProductResponse> findProducts(ProductSearchEnum productSearchEnum, String searchString, Pageable pageable, StatusCodeEnum statusCd);

    public ServiceResponse deleteProduct(Integer proId);
}
