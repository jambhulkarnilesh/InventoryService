package com.atn.inventoryservice.controller;

import com.atn.inventoryservice.response.ColorResponse;
import com.atn.inventoryservice.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/colors")
public class ColorController {

    @Autowired
    ColorService colorService;

    @GetMapping
    public ResponseEntity<List<ColorResponse>> findAllBrands() {
        return new ResponseEntity<>(colorService.findAllColors(), HttpStatus.OK);
    }
}
