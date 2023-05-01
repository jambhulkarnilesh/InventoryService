package com.atn.inventoryservice.service.serviceImpl;

import com.atn.inventoryservice.model.Brand;
import com.atn.inventoryservice.repository.BrandRepository;
import com.atn.inventoryservice.response.BrandResponse;
import com.atn.inventoryservice.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<BrandResponse> findAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        List<BrandResponse> brandResponses = new ArrayList<>();

        for (Brand brand : brands) {
            BrandResponse response = new BrandResponse();
            response.setBrandId(brand.getBrandId());
            response.setBrandName(brand.getBrandName());
            response.setStatusCd(brand.getStatusCd());
            brandResponses.add(response);
        }
        return brandResponses;
    }
}
