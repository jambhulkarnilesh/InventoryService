package com.atn.inventoryservice.response;

import lombok.Data;

@Data
public class ProductResponse {

    private String proId;
    private String proName;
    private String proCode;
    private String cataId;
    private String cataName;
    private String subCataId;
    private String subCataName;
    private String unitMeasureId;
    private String unitOfMeasureName;
    private String brandId;
    private String brandName;
    private String vendorId;
    private String proQty;
    private String proMinQty;
    private String proCriticalQty;
    private String proDescr;
    private String proImageUrl;
    private String proHeight;
    private String proWidth;
    private String grandTotal;
    private String statusCd;

    public ProductResponse(Object[] objects){

        this.proId=String.valueOf(objects[0]);
        this.proCode=String.valueOf(objects[1]);
        this.proName=String.valueOf(objects[2]);

        this.cataId=String.valueOf(objects[3]);
        this.cataName=String.valueOf(objects[4]);
        this.subCataId=String.valueOf(objects[5]);
        this.subCataName=String.valueOf(objects[6]);
        this.unitMeasureId=String.valueOf(objects[7]);
        this.unitOfMeasureName=String.valueOf(objects[8]);
        this.brandId=String.valueOf(objects[9]);
        this.brandName=String.valueOf(objects[10]);
        this.vendorId=String.valueOf(objects[11]);
        this.proQty=String.valueOf(objects[12]);
        this.proMinQty=String.valueOf(objects[13]);
        this.proCriticalQty=String.valueOf(objects[14]);
        this.proDescr=String.valueOf(objects[15]);
        this.proImageUrl=String.valueOf(objects[16]);
        this.proHeight=String.valueOf(objects[17]);
        this.proWidth=String.valueOf(objects[18]);
        this.grandTotal=String.valueOf(objects[19]);
        this.statusCd=String.valueOf(objects[20]);
    }
}
