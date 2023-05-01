package com.atn.inventoryservice.controller;

import com.atn.inventoryservice.response.CatagoryResponse;
import com.atn.inventoryservice.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/catagories")
public class CatagoryController {
    @Autowired
    CatagoryService catagoryService;

    @GetMapping
    public ResponseEntity<List<CatagoryResponse>> findAllCatagory() {
        return new ResponseEntity<>(catagoryService.findAllCatagories(), HttpStatus.OK);
    }
}
