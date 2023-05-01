package com.atn.inventoryservice.controller;

import com.atn.inventoryservice.response.BrandResponse;
import com.atn.inventoryservice.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/brands")
public class BrandController {
    @Autowired
    BrandService brandService;

    @GetMapping
    public ResponseEntity<List<BrandResponse>> findAllBrands() {
        return new ResponseEntity<>(brandService.findAllBrands(), HttpStatus.OK);
    }
}
