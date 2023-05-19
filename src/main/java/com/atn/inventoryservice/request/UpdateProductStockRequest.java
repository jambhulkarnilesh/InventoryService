package com.atn.inventoryservice.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductStockRequest {
    private Long proMasterId;
    private int colorId;
    private int vendorId;
    private String proQty;
    private String proManuDate;
    private String proExpDate;
    private String proPrice;
    private String discPer;
    private String sgstPer;
    private String cgstPer;
    private String createdUserId;
}