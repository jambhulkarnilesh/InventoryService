package com.atn.inventoryservice.service.serviceImpl;

import com.atn.inventoryservice.model.SubCatagory;
import com.atn.inventoryservice.repository.SubCatagoryRepository;
import com.atn.inventoryservice.response.SubCatagoryResponse;
import com.atn.inventoryservice.service.SubCatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCatagoryServiceImpl implements SubCatagoryService {

    @Autowired
    private SubCatagoryRepository subCatagoryRepository;

    @Override
    public List<SubCatagoryResponse> findAllSubCatagories() {
        List<SubCatagory> subCatagories = subCatagoryRepository.findAll();
        List<SubCatagoryResponse> subCatagoryResponses = new ArrayList<>();

        for (SubCatagory subCatagory : subCatagories) {
            SubCatagoryResponse response = new SubCatagoryResponse();
            response.setSubCataId(subCatagory.getSubCataId());
            response.setCataId(subCatagory.getCataId());
            response.setSubCataName(subCatagory.getSubCataName());
            response.setStatusCd(subCatagory.getStatusCd());
            subCatagoryResponses.add(response);
        }
        return subCatagoryResponses;
    }
}
