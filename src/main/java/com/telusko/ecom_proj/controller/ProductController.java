package com.telusko.ecom_proj.controller;

import com.telusko.ecom_proj.model.Product;
import com.telusko.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//    public List<Product> getAllProducts() {
//        return service.getAllProducts();
//    }
    // ResponseEntity returns response status (like Response 200, Response 404)
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        // check if product is there
        Product product = service.getProductById(id);

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK); // return status 200
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // return status 404
        }
    }
}
