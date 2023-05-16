package com.atn.inventoryservice.repository;

import com.atn.inventoryservice.constants.SQLQueryConstant;
import com.atn.inventoryservice.model.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer> {

    @Query(value = SQLQueryConstant.ALL_PRODUCTS, nativeQuery = true)
    List<Object[]> getAllProducts(@Param("status_cd") String status_cd);

    @Query(value = SQLQueryConstant.BY_PRODUCT_NAME, nativeQuery = true)
    List<Object[]> getByProductName(@Param("searchString") String searchString, @Param("status_cd") String status_cd);
}
