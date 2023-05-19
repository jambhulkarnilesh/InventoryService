package com.atn.inventoryservice.repository;

import com.atn.inventoryservice.constants.SQLQueryConstant;
import com.atn.inventoryservice.model.Product;
import com.atn.inventoryservice.model.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Modifying
    @Transactional
    @Query(value = SQLQueryConstant.DELETE_PRODUCT_BY_ID, nativeQuery = true)
    public void deleteProductById(@Param("proId") Long proId);
}
