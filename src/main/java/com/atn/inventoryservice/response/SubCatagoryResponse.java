package com.atn.inventoryservice.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubCatagoryResponse {

    private int subCataId;
    private String subCataName;
    private int cataId;
    private String statusCd;
}
