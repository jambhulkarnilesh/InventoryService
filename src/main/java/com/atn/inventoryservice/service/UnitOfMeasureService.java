package com.atn.inventoryservice.service;

import com.atn.inventoryservice.response.UnitOfMeasureResponse;

import java.util.List;

public interface UnitOfMeasureService {

    public List<UnitOfMeasureResponse> findAllUnitOfMeasures();
}
