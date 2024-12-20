package com.telusko.ecom_proj.repository;

import com.telusko.ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository<ClassWorkingWith, PrimaryKeyType (would be id type)>
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
