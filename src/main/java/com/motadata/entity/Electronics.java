package com.motadata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Electronics extends Product {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String modelName;

    @Column(nullable = false)
    private Integer warrantyInMonths;

    public Electronics(String name, Float price, Integer stock, String category, String brand, String modelName, Integer warrantyInMonths) {
        super(price, stock, category);  
        this.name = name;
        this.brand = brand;
        this.modelName = modelName;
        this.warrantyInMonths = warrantyInMonths;
    }
}