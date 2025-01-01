package com.motadata.dto;

import com.motadata.entity.Electronics;
import com.motadata.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	private String name;
	private String category;
	private Float price;
	private Integer stock;

	private String brand;
	private String modelName;
	private Integer warrantyInMonths;

	public Product toProductEntity() {
		return new Product(price, stock, category);
	}

	public Electronics toElectronicsEntity() {
		Electronics electronics = new Electronics(name, price, stock, category, brand, modelName, warrantyInMonths);
		return electronics;
	}

	public static void updateData(Electronics electronics, ProductDTO productDTO) {
		if (productDTO.getPrice() != null) {
			electronics.setPrice(productDTO.getPrice());
		}
		if (productDTO.getStock() != null) {
			electronics.setStock(productDTO.getStock());
		}
		if (productDTO.getCategory() != null) {
			electronics.setCategory(productDTO.getCategory());
		}
		if (productDTO.getName() != null) {
			electronics.setName(productDTO.getName());
		}
		if (productDTO.getBrand() != null) {
			electronics.setBrand(productDTO.getBrand());
		}
		if (productDTO.getModelName() != null) {
			electronics.setModelName(productDTO.getModelName());
		}
		if (productDTO.getWarrantyInMonths() != null) {
			electronics.setWarrantyInMonths(productDTO.getWarrantyInMonths());
		}
	}
}


