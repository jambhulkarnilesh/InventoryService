package com.atn.inventoryservice.repository;

import com.atn.inventoryservice.model.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatagoryRepository extends JpaRepository<Catagory, Integer> {
}
