package com.motadata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private String category;

    public Product(Float price, Integer stock, String category) {
        this.price = price;
        this.stock = stock;
        this.category = category;
    }
}