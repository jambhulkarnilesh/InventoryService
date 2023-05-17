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
    List<Object[]> getAllProductsForAll(@Param("pageSize")Integer pageSize, @Param("pageOffset")Integer pageOffset);

    @Query(value = SQLQueryConstant.ALL_PRODUCTS_BY_STATUS, nativeQuery = true)
    List<Object[]> getAllProductsWithStatusCd(@Param("status_cd") String statusCd,@Param("pageSize")Integer pageSize, @Param("pageOffset")Integer pageOffset);

    @Query(value = SQLQueryConstant.BY_PRODUCT_NAME, nativeQuery = true)
    List<Object[]> getByProductName(@Param("searchString") String searchString, @Param("statusCd") String statusCd, @Param("pageSize")Integer pageSize, @Param("pageOffset")Integer pageOffset);

    @Query(value = SQLQueryConstant.COUNT_BY_PRODUCT_NAME, nativeQuery = true)
    public Long getCountByProductName(@Param("searchString") String searchString, @Param("statusCd") String statusCd);

}
