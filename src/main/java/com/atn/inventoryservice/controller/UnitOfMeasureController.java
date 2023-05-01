package com.atn.inventoryservice.controller;

import com.atn.inventoryservice.response.UnitOfMeasureResponse;
import com.atn.inventoryservice.service.UnitOfMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/unit-of-measures")
public class UnitOfMeasureController {

    @Autowired
    UnitOfMeasureService unitOfMeasureService;

    @GetMapping
    public ResponseEntity<List<UnitOfMeasureResponse>> findAllUnitOfMeasures() {
        return new ResponseEntity<>(unitOfMeasureService.findAllUnitOfMeasures(), HttpStatus.OK);
    }
}
