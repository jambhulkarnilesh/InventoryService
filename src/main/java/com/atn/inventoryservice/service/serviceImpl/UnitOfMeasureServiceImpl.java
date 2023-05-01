package com.atn.inventoryservice.service.serviceImpl;

import com.atn.inventoryservice.model.UnitOfMeasure;
import com.atn.inventoryservice.repository.UnitOfMeasureRepository;
import com.atn.inventoryservice.response.UnitOfMeasureResponse;
import com.atn.inventoryservice.service.UnitOfMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    public List<UnitOfMeasureResponse> findAllUnitOfMeasures() {
        List<UnitOfMeasure> unitOfMeasures = unitOfMeasureRepository.findAll();
        List<UnitOfMeasureResponse> unitOfMeasureResponses = new ArrayList<>();

        for (UnitOfMeasure unitOfMeasure : unitOfMeasures) {
            UnitOfMeasureResponse response = new UnitOfMeasureResponse();
            response.setUnitOfMeasureId(unitOfMeasure.getUnitOfMeasureId());
            response.setUnitOfMeasureName(unitOfMeasure.getUnitOfMeasureName());
            response.setStatusCd(unitOfMeasure.getStatusCd());
            unitOfMeasureResponses.add(response);
        }
        return unitOfMeasureResponses;
    }
}
