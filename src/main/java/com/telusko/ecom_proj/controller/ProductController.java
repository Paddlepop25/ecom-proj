package com.telusko.ecom_proj.controller;

import com.telusko.ecom_proj.model.Product;
import com.telusko.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin // to prevent CORS error on reac
@RequestMapping("/api")
public class ProductController {

    // testing connection
    @RequestMapping("/")
    public String greet() {
        return "Hello there!";
    }

    // Controller talk to Service to get data
    // 1 Field Injection - he don't recommend but use coz shorter code
//    @Autowired // connect to service
//    private ProductService service;

    private ProductService service;
    // 2 Constructor injection - he recommend this
    // create constructor
    public ProductController (ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.getProductById(id);
    }
}
