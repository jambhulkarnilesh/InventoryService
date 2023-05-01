package com.atn.inventoryservice.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UnitOfMeasureResponse {

    private int unitOfMeasureId;
    private String unitOfMeasureName;
    private String statusCd;
}
