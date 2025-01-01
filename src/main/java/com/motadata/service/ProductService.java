package com.motadata.service;

import java.util.List;

import com.motadata.apiresponse.ApiResponse;
import com.motadata.dto.ProductDTO;

public interface ProductService {

	ApiResponse healthCheck();

	ApiResponse getAllProducts() throws Exception;

	ApiResponse getOnlyProduct(Integer id) throws Exception;

	ApiResponse deleteProduct(Integer id) throws Exception;

	ApiResponse createProduct(List<ProductDTO> products) throws Exception;

	ApiResponse updateProduct(Integer id, ProductDTO productDTO) throws Exception;

}