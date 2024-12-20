package com.telusko.ecom_proj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity // indicates this Class map to table
@Data // lombok - this class returns data
@AllArgsConstructor // lombok - will create constructor
@NoArgsConstructor // lombok - will create noargs constructor
public class Product {

    @Id // indicates primary key
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String Category;
    private Date releaseDate;
    private boolean available;
    private int quantity;
}
