package com.atn.inventoryservice.service.serviceImpl;

import com.atn.inventoryservice.model.Product;
import com.atn.inventoryservice.model.ProductMaster;
import com.atn.inventoryservice.repository.ProductMasterRepository;
import com.atn.inventoryservice.repository.ProductRepository;
import com.atn.inventoryservice.request.ProductRequest;
import com.atn.inventoryservice.request.UpdateProductStockRequest;
import com.atn.inventoryservice.response.ServiceResponse;
import com.atn.inventoryservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMasterRepository productMasterRepository;

    @Override
    public ServiceResponse saveProduct(ProductRequest productRequest) {
        Product product = converProRequestToProduct(productRequest);
        ProductMaster productMaster = converProRequestToProMaster(productRequest);
        productRepository.save(product);
        productMasterRepository.save(productMaster);
        return ServiceResponse.builder()
                .isSuccess(true)
                .responseMessage("Record inserted successfully")
                .build();
    }

    @Override
    public ServiceResponse updateProductStocks(UpdateProductStockRequest productStockRequest) {
        Product product = converUpdateProRequestToProduct(productStockRequest);
        productRepository.save(product);
        Optional<ProductMaster> productMaster=productMasterRepository.findById(productStockRequest.getProMasterId());

        if(productMaster.isPresent()){
            ProductMaster master=productMaster.get();
            double proQty=Double.parseDouble(master.getProQty())+Double.parseDouble(productStockRequest.getProQty());
            master.setProQty(String.valueOf(proQty));
            productMasterRepository.save(master);
        }

        return ServiceResponse.builder()
                .isSuccess(true)
                .responseMessage("Record inserted successfully")
                .build();
    }

    private Product converUpdateProRequestToProduct(UpdateProductStockRequest productStockRequest) {
        Product product = new Product();
        product.setProMasterId(productStockRequest.getProMasterId());
        product.setColorId(productStockRequest.getColorId());
        product.setCataId(productStockRequest.getCataId());
        product.setSubCataId(productStockRequest.getSubCataId());
        product.setUnitMeasureId(productStockRequest.getUnitMeasureId());
        product.setBrandId(productStockRequest.getBrandId());
        product.setVendorId(productStockRequest.getVendorId());
        product.setProQty(productStockRequest.getProQty());
        product.setProManuDate(productStockRequest.getProManuDate());
        product.setProExpDate(productStockRequest.getProExpDate());
        product.setProPrice(productStockRequest.getProPrice());
        product.setDiscPer(productStockRequest.getDiscPer());
        product.setSgstPer(productStockRequest.getSgstPer());
        product.setCgstPer(productStockRequest.getCgstPer());
        product.setStatusCd("A");
        product.setCreatedUserId(productStockRequest.getCreatedUserId());
        return product;
    }

    private ProductMaster converProRequestToProMaster(ProductRequest productRequest) {
        ProductMaster productMaster = new ProductMaster();
        productMaster.setProName(productRequest.getProName());
        productMaster.setCataId(productRequest.getCataId());
        productMaster.setSubCataId(productRequest.getSubCataId());
        productMaster.setUnitMeasureId(productRequest.getUnitMeasureId());
        productMaster.setBrandId(productRequest.getBrandId());
        productMaster.setVendorId(productRequest.getVendorId());
        productMaster.setProQty(productRequest.getProQty());
        productMaster.setProMinQty(productRequest.getProMinQty());
        productMaster.setProCriticalQty(productRequest.getProCriticalQty());
        productMaster.setProDescr(productRequest.getProDescr());
        productMaster.setProImageUrl(productRequest.getProImageUrl());
        productMaster.setProHeight(productRequest.getProHeight());
        productMaster.setProWidth(productRequest.getProWidth());
        productMaster.setStatusCd("A");
        productMaster.setCreatedUserId(productRequest.getCreatedUserId());
        return productMaster;
    }

    private Product converProRequestToProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setColorId(productRequest.getColorId());
        product.setCataId(productRequest.getCataId());
        product.setSubCataId(productRequest.getSubCataId());
        product.setUnitMeasureId(productRequest.getUnitMeasureId());
        product.setBrandId(productRequest.getBrandId());
        product.setVendorId(productRequest.getVendorId());
        product.setProQty(productRequest.getProQty());
        product.setProManuDate(productRequest.getProManuDate());
        product.setProExpDate(productRequest.getProExpDate());
        product.setProPrice(productRequest.getProPrice());
        product.setDiscPer(productRequest.getDiscPer());
        product.setSgstPer(productRequest.getSgstPer());
        product.setCgstPer(productRequest.getCgstPer());
        product.setStatusCd("A");
        product.setCreatedUserId(productRequest.getCreatedUserId());
        return product;
    }
}
