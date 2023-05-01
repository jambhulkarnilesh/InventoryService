package com.atn.inventoryservice.service;

import com.atn.inventoryservice.response.CatagoryResponse;

import java.util.List;

public interface CatagoryService {

    public List<CatagoryResponse> findAllCatagories();
}
