package com.atn.inventoryservice.service.serviceImpl;

import com.atn.inventoryservice.constants.AppConsts;
import com.atn.inventoryservice.constants.ProductSearchEnum;
import com.atn.inventoryservice.constants.StatusCodeEnum;
import com.atn.inventoryservice.model.Product;
import com.atn.inventoryservice.model.ProductMaster;
import com.atn.inventoryservice.repository.ProductMasterRepository;
import com.atn.inventoryservice.repository.ProductRepository;
import com.atn.inventoryservice.request.ProductRequest;
import com.atn.inventoryservice.request.UpdateProductStockRequest;
import com.atn.inventoryservice.response.ProductResponse;
import com.atn.inventoryservice.response.ServiceResponse;
import com.atn.inventoryservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMasterRepository productMasterRepository;

    @Override
    public ServiceResponse saveProduct(ProductRequest productRequest) {
        Optional<ProductMaster> productMasters=productMasterRepository.findByProName(productRequest.getProName());
        if(productMasters.isPresent()){
            return ServiceResponse.builder()
                    .isSuccess(false)
                    .responseMessage(AppConsts.RECORD_ALREADY_EXIST)
                    .build();
        }
        long proId = productMasterRepository.count() + 1;
        String proCode="pro_"+proId;
        String proBarCode="*"+proId+"*";

        Product product = converProRequestToProduct(productRequest, proId,proCode, proBarCode);
        ProductMaster productMaster = converProRequestToProMaster(productRequest, proId,proCode);
        productRepository.save(product);
        productMasterRepository.save(productMaster);
        return ServiceResponse.builder()
                .isSuccess(true)
                .responseMessage(AppConsts.RECORD_INSERTED)
                .build();
    }

    @Override
    public ServiceResponse updateProductStocks(UpdateProductStockRequest productStockRequest) {
        Product product = converUpdateProRequestToProduct(productStockRequest, productStockRequest.getProMasterId());
        productRepository.save(product);
        Optional<ProductMaster> productMaster = productMasterRepository.findByProMasterIdAndStatusCd(productStockRequest.getProMasterId(), "A");

        if (productMaster.isPresent()) {
            ProductMaster master = productMaster.get();
            double proQty = Double.parseDouble(master.getProQty()) + Double.parseDouble(productStockRequest.getProQty());
            master.setProQty(String.valueOf(proQty));
            productMasterRepository.save(master);
        }

        return ServiceResponse.builder()
                .isSuccess(true)
                .responseMessage("Record inserted successfully")
                .build();
    }

    @Override
    public PageImpl<ProductResponse> findProducts(ProductSearchEnum productSearchEnum, String searchString, Pageable pageable, StatusCodeEnum statusCd) {
        List<ProductResponse> productResponses = null;
        List<Object[]> productList = null;
        Long totalRecords = null;
        Integer pageSize = pageable.getPageSize();
        Integer pageOffset = (int) pageable.getOffset();
        switch (productSearchEnum.getSearchType()) {
            case AppConsts.ALL:
                if (StatusCodeEnum.ALL.getStatusCode().equalsIgnoreCase(statusCd.getStatusCode()))
                    productList = productMasterRepository.getAllProductsForAll(pageSize, pageOffset);
                else
                    productList = productMasterRepository.getAllProductsWithStatusCd(statusCd.getStatusCode(), pageSize, pageOffset);

                if (productList.isEmpty()) {
                    return new PageImpl<>(Collections.emptyList(), pageable, totalRecords);
                }
                if (!CollectionUtils.isEmpty(productList)) {
                    productResponses = productList.stream().map(ProductResponse::new).collect(Collectors.toList());
                    totalRecords = (long) productResponses.size();
                }
                break;
            case AppConsts.PRODUCT_NAME:
                productList = productMasterRepository.getByProductName(searchString, statusCd.getStatusCode(), pageSize, pageOffset);
                if (productList.isEmpty()) {
                    return new PageImpl<>(Collections.emptyList(), pageable, totalRecords);
                }
                if (!CollectionUtils.isEmpty(productList)) {
                    productResponses = productList.stream().map(ProductResponse::new).collect(Collectors.toList());
                    totalRecords = productMasterRepository.getCountByProductName(searchString, statusCd.getStatusCode());
                }
                break;
            default:
        }

        return new PageImpl<>(productResponses, pageable, totalRecords);
    }

    private Product converUpdateProRequestToProduct(UpdateProductStockRequest productStockRequest, Long proId) {
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

    private ProductMaster converProRequestToProMaster(ProductRequest productRequest, Long proId, String proCode) {
        ProductMaster productMaster = new ProductMaster();
        productMaster.setProMasterId(proId);
        productMaster.setProCode(proCode);
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

    private Product converProRequestToProduct(ProductRequest productRequest, Long proId,String proCode, String proBarCode) {
        Product product = new Product();
        product.setProMasterId(proId);
        product.setProCode(proCode);
        product.setColorId(productRequest.getColorId());
        product.setCataId(productRequest.getCataId());
        product.setSubCataId(productRequest.getSubCataId());
        product.setUnitMeasureId(productRequest.getUnitMeasureId());
        product.setBrandId(productRequest.getBrandId());
        product.setVendorId(productRequest.getVendorId());
        product.setProQty(productRequest.getProQty());
        product.setProBarCode(proBarCode);
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

    @Override
    public ServiceResponse deleteProduct(Long prodId) {
        Optional<ProductMaster> productMaster = productMasterRepository.findByProMasterIdAndStatusCd(prodId, "A");
        if (productMaster.isPresent()) {
            try {
                productRepository.deleteProductById(prodId);
                productMasterRepository.deleteProductById(prodId);
                return ServiceResponse.builder()
                        .isSuccess(true)
                        .responseMessage(AppConsts.RECORD_DELETED)
                        .build();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return ServiceResponse.builder()
                .isSuccess(false)
                .responseMessage(AppConsts.RECORD_NOT_EXIST)
                .build();
    }
}
