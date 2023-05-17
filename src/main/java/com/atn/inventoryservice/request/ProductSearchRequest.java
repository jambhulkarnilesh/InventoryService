package com.atn.inventoryservice.request;

import com.atn.inventoryservice.constants.ProductSearchEnum;
import com.atn.inventoryservice.constants.StatusCodeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

@Builder
@Getter
@Setter
public class ProductSearchRequest {
    private ProductSearchEnum productSearchEnum;
    private String searchString;
    private Pageable pageable;
    private Integer pageSize;
    private Integer pageOffset;
    private String direction;
    private String sortParam;
    private StatusCodeEnum status_cd;
}

