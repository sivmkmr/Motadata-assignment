package com.motadata.resthandler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.motadata.apiresponse.ApiResponse;
import com.motadata.dto.ProductDTO;
import com.motadata.service.ProductService;

@Component
public class RestParameterHandler {

	private ProductService productService;

	public RestParameterHandler(ProductService productService) {
		this.productService = productService;
	}

	public ApiResponse healthCheck() {
		return productService.healthCheck();
	}
	
	public ApiResponse createProduct(List<ProductDTO> products) throws Exception{
		return productService.createProduct(products);
	}

	public ApiResponse updateProduct(Integer id, ProductDTO productDTO) throws Exception{
		return productService.updateProduct(id,productDTO);
	}

	public ApiResponse getAllProducts() throws Exception {
		return productService.getAllProducts();
	}

	public ApiResponse getOnlyProduct(Integer id) throws Exception{
		return productService.getOnlyProduct(id);
	}

	public ApiResponse deleteProduct(Integer id) throws Exception{
		return productService.deleteProduct(id);
	}


	

}
