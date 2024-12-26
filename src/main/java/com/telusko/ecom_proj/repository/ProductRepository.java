package com.telusko.ecom_proj.repository;

import com.telusko.ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// JpaRepository<ClassWorkingWith, PrimaryKeyType (would be id type)>
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // this is not SQL query.
    // this is JPQL query
    @Query("SELECT p from Product p WHERE "+"LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
            +"LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
            +"LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
            +"LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> searchProducts(String keyword);
}
