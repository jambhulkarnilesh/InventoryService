package com.atn.inventoryservice.controller;

import com.atn.inventoryservice.constants.ProductSearchEnum;
import com.atn.inventoryservice.constants.StatusCodeEnum;
import com.atn.inventoryservice.request.ProductRequest;
import com.atn.inventoryservice.request.UpdateProductStockRequest;
import com.atn.inventoryservice.response.ProductResponse;
import com.atn.inventoryservice.response.ServiceResponse;
import com.atn.inventoryservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<List<ProductResponse>> getProducts(@RequestParam ProductSearchEnum productSearchEnum,
                                                             @RequestParam(required = false) String searchString,
                                                             @RequestParam StatusCodeEnum status_cd) {
        List<ProductResponse> productResponses = productService.findProducts(productSearchEnum, searchString, status_cd);
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }


}
