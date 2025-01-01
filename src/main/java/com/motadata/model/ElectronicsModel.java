package com.motadata.model;

import com.motadata.entity.Electronics;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ElectronicsModel {

	private Integer id;
	
    private String name;

    private String brand;

    private String modelName;

    private Integer warrantyInMonths;

	public ElectronicsModel(Electronics electronics) {
		this.id = electronics.getId();
		this.name = electronics.getName();
		this.brand = electronics.getBrand();
		this.modelName = electronics.getModelName();
		this.warrantyInMonths = electronics.getWarrantyInMonths();
	}

    
 
}