package com.telusko.ecom_proj.controller;

import com.telusko.ecom_proj.model.Product;
import com.telusko.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
    // 2 Constructor injection - he recommend
    // create constructor
    public ProductController (ProductService service) {
        this.service = service;
    }

    // 3 Setter injection - doesn't work
//    public void setService (ProductService service) {
//        this.service = service;
//    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

}
