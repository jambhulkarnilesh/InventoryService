package com.atn.inventoryservice.repository;

import com.atn.inventoryservice.model.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer> {
}
