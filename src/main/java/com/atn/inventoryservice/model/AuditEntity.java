package com.atn.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditEntity {

    @Column(name = "crte_user_id")
    private String createdUserId;

    @Column(name = "crte_ts")
    private Timestamp createdDate;

    @Column(name = "lst_updt_ts")
    private Timestamp updatedDate;

    @Column(name = "lst_updt_user_id")
    private String updatedUserId;
}
