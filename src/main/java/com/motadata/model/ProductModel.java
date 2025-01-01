package com.motadata.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.motadata.entity.Electronics;
import com.motadata.entity.Product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
public class ProductModel {

    private Integer id;
    private String name;
    private Float price;
    private Integer stock;
    private String category;
    private String brand;
    private String modelName;
    private Integer warrantyInMonths;
    private ElectronicsModel data;
    
    public ProductModel(Product product) {
        this.id = product.getId();
        this.category = product.getCategory();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }

    public ProductModel(Electronics electronics) {
        this.id = electronics.getId();
        this.name = electronics.getName();
        this.price = electronics.getPrice();
        this.stock = electronics.getStock();
        this.category = electronics.getCategory();
        this.brand = electronics.getBrand();
        this.modelName = electronics.getModelName();
        this.warrantyInMonths = electronics.getWarrantyInMonths();
    }

	
}