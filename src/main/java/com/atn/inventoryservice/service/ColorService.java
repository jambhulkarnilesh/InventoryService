package com.atn.inventoryservice.service;

import com.atn.inventoryservice.response.ColorResponse;

import java.util.List;

public interface ColorService {

    public List<ColorResponse> findAllColors();
}
