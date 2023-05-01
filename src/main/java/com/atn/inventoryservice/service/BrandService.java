package com.atn.inventoryservice.service;

import com.atn.inventoryservice.response.BrandResponse;
import com.atn.inventoryservice.response.CatagoryResponse;

import java.util.List;

public interface BrandService {

    public List<BrandResponse> findAllBrands();
}
