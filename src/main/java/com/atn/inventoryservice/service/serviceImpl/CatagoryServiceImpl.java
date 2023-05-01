package com.atn.inventoryservice.service.serviceImpl;

import com.atn.inventoryservice.model.Catagory;
import com.atn.inventoryservice.repository.CatagoryRepository;
import com.atn.inventoryservice.response.CatagoryResponse;
import com.atn.inventoryservice.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatagoryServiceImpl implements CatagoryService {

    @Autowired
    private CatagoryRepository catagoryRepository;

    @Override
    public List<CatagoryResponse> findAllCatagories() {
        List<Catagory> catagories = catagoryRepository.findAll();
        List<CatagoryResponse> catagoryResponses = new ArrayList<>();

        for (Catagory catagory : catagories) {
            CatagoryResponse response = new CatagoryResponse();
            response.setCataId(catagory.getCataId());
            response.setCataName(catagory.getCataName());
            response.setStatusCd(catagory.getStatusCd());
            catagoryResponses.add(response);
        }
        return catagoryResponses;
    }
}
