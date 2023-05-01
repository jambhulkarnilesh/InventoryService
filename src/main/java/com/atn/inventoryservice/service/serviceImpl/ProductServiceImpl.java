package com.atn.inventoryservice.service.serviceImpl;

import com.atn.inventoryservice.model.Product;
import com.atn.inventoryservice.repository.ProductRepository;
import com.atn.inventoryservice.request.ProductRequest;
import com.atn.inventoryservice.response.ServiceResponse;
import com.atn.inventoryservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ServiceResponse saveProduct(ProductRequest productRequest) {
        Product product = converProduct(productRequest);
        productRepository.save(product);
        return ServiceResponse.builder()
                .isSuccess(true)
                .responseMessage("Record inserted successfully")
                .build();
    }

    private Product converProduct(ProductRequest productRequest) {
        Product product=new Product();
        product.setProName(productRequest.getProName());
        product.setColorId(productRequest.getColorId());
        product.setCataId(productRequest.getCataId());
        product.setSubCataId(productRequest.getSubCataId());
        product.setUnitMeasureId(productRequest.getUnitMeasureId());
        product.setBrandId(productRequest.getBrandId());
        product.setVendorId(productRequest.getVendorId());
        product.setProQty(productRequest.getProQty());
        product.setProMinQty(productRequest.getProMinQty());
        product.setProCriticalQty(productRequest.getProCriticalQty());
        product.setProDescr(productRequest.getProDescr());
        product.setProManuDate(productRequest.getProManuDate());
        product.setProExpDate(productRequest.getProExpDate());
        product.setProImageUrl(productRequest.getProImageUrl());
        product.setProHeight(productRequest.getProHeight());
        product.setProWidth(productRequest.getProWidth());
        product.setProPrice(productRequest.getProPrice());
        product.setDiscPer(productRequest.getDiscPer());
        product.setSgstPer(productRequest.getSgstPer());
        product.setCgstPer(productRequest.getCgstPer());
        product.setStatusCd("A");
        product.setCreatedUserId(productRequest.getCreatedUserId());
        return product;
    }
}
