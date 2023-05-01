package com.atn.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "product")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product extends  AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private int proId;

    @Column(name = "pro_name")
    private String proName;

    @Column(name = "color_id")
    private int colorId;

    @Column(name = "cata_id")
    private int cataId;

    @Column(name = "sub_cata_id")
    private int subCataId;

    @Column(name = "um_id")
    private int unitMeasureId;

    @Column(name = "brand_id")
    private int brandId;

    @Column(name = "vendor_id")
    private int vendorId;

    @Column(name = "pro_qty")
    private String proQty;

    @Column(name = "pro_min_qty")
    private String proMinQty;

    @Column(name = "pro_critical_qty")
    private String proCriticalQty;

    @Column(name = "pro_desc")
    private String proDescr;

    @Column(name = "pro_bar_code")
    private String proBarCode;

    @Column(name = "pro_manu_date")
    private String proManuDate;

    @Column(name = "pro_exp_date")
    private String proExpDate;

    @Column(name = "pro_image")
    private String proImageUrl;

    @Column(name = "pro_height")
    private String proHeight;

    @Column(name = "pro_width")
    private String proWidth;

    @Column(name = "pro_price")
    private String proPrice;

    @Column(name = "dis_per")
    private String discPer;

    @Column(name = "dis_rs")
    private String discRs;

    @Column(name = "pro_price_disc")
    private String prdProPrice;

    @Column(name = "sgst_per")
    private String sgstPer;

    @Column(name = "sgst_rs")
    private String sgstRs;

    @Column(name = "cgst_per")
    private String cgstPer;

    @Column(name = "cgst_rs")
    private String cgstRs;

    @Column(name = "grand_total")
    private String grandTotal;

    @Column(name = "status_cd")
    private  String statusCd;
}
