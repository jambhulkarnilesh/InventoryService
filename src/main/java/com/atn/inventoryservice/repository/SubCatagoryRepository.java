package com.atn.inventoryservice.repository;


import com.atn.inventoryservice.model.SubCatagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCatagoryRepository extends JpaRepository<SubCatagory, Integer> {
}
