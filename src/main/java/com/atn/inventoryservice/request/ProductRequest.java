package com.atn.inventoryservice.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private String proName;
    private int colorId;
    private int cataId;
    private int subCataId;
    private int unitMeasureId;
    private int brandId;
    private int vendorId;
    private String proQty;
    private String proMinQty;
    private String proCriticalQty;
    private String proDescr;
    private String proManuDate;
    private String proExpDate;
    private String proImageUrl;
    private String proHeight;
    private String proWidth;
    private String proPrice;
    private String discPer;
    private String sgstPer;
    private String cgstPer;
    private String createdUserId;
}
