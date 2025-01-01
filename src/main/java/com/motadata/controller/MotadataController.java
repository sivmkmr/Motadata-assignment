package com.motadata.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.motadata.apiresponse.ApiResponse;
import com.motadata.dto.ProductDTO;
import com.motadata.resthandler.RestParameterHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping
public class MotadataController {

	@Autowired
	private RestParameterHandler restParameterHandler;

	@GetMapping("/ecshealthcheck")
	public ResponseEntity<ApiResponse> healthCheck() {
		log.info("healthCheck {} ->", LocalDateTime.now());
		return new ResponseEntity<>(restParameterHandler.healthCheck(), HttpStatus.OK);
	}

	@PostMapping("/create-product")
	public ResponseEntity<ApiResponse> createProduct(@RequestBody List<ProductDTO> products) throws Exception {
		return new ResponseEntity<>(restParameterHandler.createProduct(products), HttpStatus.CREATED);
	}

	@PutMapping("/update-product")
	public ResponseEntity<ApiResponse> updateProduct(@RequestParam(defaultValue = "none") Integer id,
			@RequestBody ProductDTO productDTO) throws Exception {
		return new ResponseEntity<>(restParameterHandler.updateProduct(id, productDTO), HttpStatus.OK);
	}

	@GetMapping("/get-all-products")
	public ResponseEntity<ApiResponse> getAllProducts() throws Exception {
		return new ResponseEntity<>(restParameterHandler.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/get-product-by-id")
	public ResponseEntity<ApiResponse> getOnlyProduct(@RequestParam(defaultValue = "0") Integer id) throws Exception {
		return new ResponseEntity<>(restParameterHandler.getOnlyProduct(id), HttpStatus.OK);
	}

	@DeleteMapping("/delete-by-id")
	public ResponseEntity<ApiResponse> deleteProduct(@RequestParam(defaultValue = "0") Integer id) throws Exception {
		return new ResponseEntity<>(restParameterHandler.deleteProduct(id), HttpStatus.OK);
	}

}
