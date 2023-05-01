package com.atn.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "product_master")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductMaster extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_master_id")
    private int proId;

    @Column(name = "pro_name")
    private String proName;

    @Column(name = "pro_code")
    private String proCode;

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

    @Column(name = "pro_image")
    private String proImageUrl;

    @Column(name = "pro_height")
    private String proHeight;

    @Column(name = "pro_width")
    private String proWidth;

    @Column(name = "grand_total")
    private String grandTotal;

    @Column(name = "status_cd")
    private  String statusCd;
}
