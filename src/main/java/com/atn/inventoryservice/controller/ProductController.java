package com.atn.inventoryservice.controller;

import com.atn.inventoryservice.request.ProductRequest;
import com.atn.inventoryservice.request.UpdateProductStockRequest;
import com.atn.inventoryservice.response.ServiceResponse;
import com.atn.inventoryservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


}
