package com.atn.inventoryservice.controller;


import com.atn.inventoryservice.response.SubCatagoryResponse;
import com.atn.inventoryservice.service.SubCatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sub-catagories")
public class SubCatagoryController {

    @Autowired
    SubCatagoryService subCatagoryService;

    @GetMapping
    public ResponseEntity<List<SubCatagoryResponse>> findAllSubCatagories() {
        return new ResponseEntity<>(subCatagoryService.findAllSubCatagories(), HttpStatus.OK);
    }
}
