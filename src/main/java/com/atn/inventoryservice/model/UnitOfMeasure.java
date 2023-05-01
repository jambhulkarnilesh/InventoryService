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

@Table(name = "unit_measures")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UnitOfMeasure extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "um_id")
    private int unitOfMeasureId;

    @Column(name = "um_name")
    private  String unitOfMeasureName;

    @Column(name = "status_cd")
    private  String statusCd;
}
