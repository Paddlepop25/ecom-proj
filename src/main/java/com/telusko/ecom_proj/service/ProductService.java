package com.telusko.ecom_proj.service;

import com.telusko.ecom_proj.model.Product;
import com.telusko.ecom_proj.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    // get all products
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }
}
