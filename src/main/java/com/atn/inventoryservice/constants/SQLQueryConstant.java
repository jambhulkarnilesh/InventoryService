package com.atn.inventoryservice.constants;

public class SQLQueryConstant {

    public static final String ALL_PRODUCTS = "select pm.pro_master_id,COALESCE(pm.pro_code,'') as proCode,COALESCE(pm.pro_name,'') as proName,pm.cata_id,COALESCE(cat.cata_name,'') as cataName,pm.sub_cata_id,COALESCE(sub_cat.sub_cata_name,'') as subCataName,pm.um_id,COALESCE(um.um_name,'') as umName,pm.brand_id,COALESCE(br.brand_name,'') as brandName, pm.vendor_id,pm.pro_qty,pm.pro_min_qty,pm.pro_critical_qty,COALESCE(pm.pro_desc,'') as proDesc,COALESCE(pm.pro_bar_code,'') as proBarCode,pm.pro_image,pm.pro_height,pm.pro_width, pm.status_cd from product_master pm, brand br, catagory cat,sub_catagory sub_cat, unit_measures um where pm.brand_id = br.brand_id and pm.cata_id=cat.cata_id and sub_cat.sub_cata_id=pm.sub_cata_id and um.um_id=pm.um_id  and pm.status_cd=?";
    public static final String BY_PRODUCT_NAME = "select pm.pro_master_id,COALESCE(pm.pro_code,'') as proCode,COALESCE(pm.pro_name,'') as proName,pm.cata_id,COALESCE(cat.cata_name,'') as cataName,pm.sub_cata_id,COALESCE(sub_cat.sub_cata_name,'') as subCataName,pm.um_id,COALESCE(um.um_name,'') as umName,pm.brand_id,COALESCE(br.brand_name,'') as brandName, pm.vendor_id,pm.pro_qty,pm.pro_min_qty,pm.pro_critical_qty,COALESCE(pm.pro_desc,'') as proDesc,COALESCE(pm.pro_bar_code,'') as proBarCode,pm.pro_image,pm.pro_height,pm.pro_width, pm.status_cd from product_master pm, brand br, catagory cat,sub_catagory sub_cat, unit_measures um where pm.brand_id = br.brand_id and pm.cata_id=cat.cata_id and sub_cat.sub_cata_id=pm.sub_cata_id and um.um_id=pm.um_id  and pm.pro_name=? and pm.status_cd=?";
}
