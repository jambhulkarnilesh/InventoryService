package com.atn.inventoryservice.controller;

import com.atn.inventoryservice.constants.ProductSearchEnum;
import com.atn.inventoryservice.constants.StatusCodeEnum;
import com.atn.inventoryservice.request.ProductRequest;
import com.atn.inventoryservice.request.UpdateProductStockRequest;
import com.atn.inventoryservice.response.ServiceResponse;
import com.atn.inventoryservice.service.ProductService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<ServiceResponse> saveProducts(@RequestBody ProductRequest productRequest) {
        return new ResponseEntity<>(productService.saveProduct(productRequest), HttpStatus.OK);
    }

    @PostMapping("/update-stock")
    public ResponseEntity<ServiceResponse> updateProductStocks(@RequestBody UpdateProductStockRequest productStockRequest) {
        return new ResponseEntity<>(productService.updateProductStocks(productStockRequest), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getProducts(@Parameter ProductSearchEnum productSearchEnum,
                                              @Parameter(example = "proName") String searchString,
                                              @Parameter Pageable pageable,
                                              @Parameter StatusCodeEnum statusCd) {
        return new ResponseEntity<>(productService.findProducts(productSearchEnum, searchString, pageable, statusCd), HttpStatus.OK);
    }


}
