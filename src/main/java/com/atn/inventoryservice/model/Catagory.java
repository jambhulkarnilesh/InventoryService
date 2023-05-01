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

@Table(name = "catagory")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Catagory extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cata_id")
    private int cataId;

    @Column(name = "cata_name")
    private  String cataName;

    @Column(name = "status_cd")
    private  String statusCd;
}
