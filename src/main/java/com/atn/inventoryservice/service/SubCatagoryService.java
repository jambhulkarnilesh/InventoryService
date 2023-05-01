package com.atn.inventoryservice.service;

import com.atn.inventoryservice.response.SubCatagoryResponse;

import java.util.List;

public interface SubCatagoryService {

    public List<SubCatagoryResponse> findAllSubCatagories();
}
