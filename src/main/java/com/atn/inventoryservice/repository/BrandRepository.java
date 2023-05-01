package com.atn.inventoryservice.repository;

import com.atn.inventoryservice.model.Brand;
import com.atn.inventoryservice.model.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
