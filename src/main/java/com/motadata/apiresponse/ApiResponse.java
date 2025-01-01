package com.motadata.apiresponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.motadata.model.ProductModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

	private String message;
	
	private List<ProductModel> products;

	private ProductModel product;

}
