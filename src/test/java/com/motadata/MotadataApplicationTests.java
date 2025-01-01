package com.motadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.motadata.apiresponse.ApiResponse;
import com.motadata.dao.repository.ElectronicsRepository;
import com.motadata.dto.ProductDTO;
import com.motadata.entity.Electronics;
import com.motadata.serviceimpl.ProductServiceImpl;

@SpringBootTest
public class MotadataApplicationTests {

	@Mock
	private ElectronicsRepository productRepository;

	@InjectMocks
	private ProductServiceImpl productService;

	private Electronics product;
	private ProductDTO productDTO;
	private List<Electronics> productList;
	private ApiResponse response;

	@BeforeEach
	void setUp() {
		// Initialize mock data
		product = new Electronics();
		product.setId(1);
		product.setName("Laptop");

		productDTO = new ProductDTO();
		productDTO.setName("ProductDTO");

		productList = new ArrayList<>();
		productList.add(product);

		response = new ApiResponse();
	}

	@Test
	void testHealthCheck() {
		ApiResponse healthCheckResponse = productService.healthCheck();
		assertNotNull(healthCheckResponse);
		assertTrue(healthCheckResponse.getMessage().contains("OK"));
	}





	@Test
    void testDeleteProductSuccess() {
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        doNothing().when(productRepository).deleteById(1);
        ApiResponse apiResponse = productService.deleteProduct(1);
        assertEquals("Product has been successfully deleted with this Id: 1", apiResponse.getMessage());
    }

	@Test
    void testDeleteProductNotFound() {
        when(productRepository.findById(1)).thenReturn(Optional.empty());
        ApiResponse apiResponse = productService.deleteProduct(1);
        assertEquals("Product not found with this Id: 1", apiResponse.getMessage());
    }

	@Test
	void testCreateProductSuccess() throws Exception {
		List<ProductDTO> productDTOList = new ArrayList<>();
		productDTOList.add(productDTO);
		when(productRepository.saveAll(anyList())).thenReturn(productList);
		ApiResponse apiResponse = productService.createProduct(productDTOList);
		assertEquals("Products have been successfully created.", apiResponse.getMessage());
	}

	@Test
	void testCreateProductFailure() throws Exception {
		List<ProductDTO> productDTOList = new ArrayList<>();
		productDTOList.add(productDTO);
		when(productRepository.saveAll(anyList())).thenThrow(new RuntimeException("Database Error"));
		ApiResponse apiResponse = productService.createProduct(productDTOList);
		assertEquals("An unexpected error occurred while creating the products.", apiResponse.getMessage());
	}

	@Test
    void testUpdateProductSuccess() {
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Electronics.class))).thenReturn(product);
        ApiResponse apiResponse = productService.updateProduct(1, productDTO);

        assertEquals("Product updated successfully.", apiResponse.getMessage());
    }

	@Test
    void testUpdateProductNotFound() {
        when(productRepository.findById(100)).thenReturn(Optional.empty());
        ApiResponse apiResponse = productService.updateProduct(100, productDTO);
        assertEquals("Product not found with this Id: 100", apiResponse.getMessage());
    }
}
