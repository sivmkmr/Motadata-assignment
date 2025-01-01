package com.motadata.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.motadata.apiresponse.ApiResponse;
import com.motadata.dao.repository.ElectronicsRepository;
import com.motadata.dao.repository.ProductRepository;
import com.motadata.dto.ProductDTO;
import com.motadata.entity.Electronics;
import com.motadata.entity.Product;
import com.motadata.exception.ElectronicsNotFoundException;
import com.motadata.exception.ProductNotFoundException;
import com.motadata.globalconstant.GlobalConstant;
import com.motadata.model.ElectronicsModel;
import com.motadata.model.ProductModel;
import com.motadata.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private ElectronicsRepository electronicsRepository;

	public ProductServiceImpl(ElectronicsRepository electronicsRepository, ProductRepository productRepository) {
		this.electronicsRepository = electronicsRepository;
		this.productRepository = productRepository;
	}

	@Override
	public ApiResponse healthCheck() {
		ApiResponse response = new ApiResponse();
		response.setMessage("OK Current Date and Time ->" + LocalDateTime.now().toString());
		return response;
	}

	@Override
	public ApiResponse getAllProducts() throws Exception {
		ApiResponse response = new ApiResponse();
		List<Product> productList = productRepository.findAll();

		// if Data not found then you will get 500 we can handle in many ways on of the
		// best creating own exception class
		Map<Integer, Electronics> map = electronicsRepository.findAll().stream()
				.collect(Collectors.toMap(Electronics::getId, e -> e));
		List<ProductModel> pList = new ArrayList<>();
		for (Product p : productList) {
			ProductModel pModel = new ProductModel(p);
			pModel.setData(new ElectronicsModel(map.get(p.getId())));
			pList.add(pModel);
		}
		response.setProducts(pList);
		return response;
	}

	@Override
	
	public ApiResponse getOnlyProduct(Integer id) throws Exception {
	    ApiResponse response = new ApiResponse();
	    Optional<Product> dbOptional = productRepository.findById(id);
	    Map<Integer, Electronics> map = electronicsRepository.findAll().stream()
	            .collect(Collectors.toMap(Electronics::getId, e -> e));
	    if (dbOptional.isEmpty()) {
	    	throw new ProductNotFoundException(GlobalConstant.NOT_FOUND + id);
	    } else {
	        Product dbData = dbOptional.get();
	        ProductModel pModel = new ProductModel(dbData);
	        Electronics electronicsData = map.get(id);
	        if (electronicsData != null) {
	            pModel.setData(new ElectronicsModel(electronicsData));
	        } else {
	        	
				throw new ElectronicsNotFoundException(GlobalConstant.NOT_FOUND + id);
			}
	        response.setProduct(pModel);
	    }
	    return response;
	}

	@Override
	public ApiResponse deleteProduct(Integer id) {
		ApiResponse response = new ApiResponse();
		Optional<Electronics> dbProduct = electronicsRepository.findById(id);
		dbProduct.ifPresentOrElse(product -> {
			electronicsRepository.deleteById(id);
			ProductModel productModel = new ProductModel(product);
			response.setMessage(GlobalConstant.DELETE_SUCCESS + id);
			response.setProduct(productModel);
		}, () -> {
			response.setMessage(GlobalConstant.NOT_FOUND + id);
		});
		return response;
	}

	@Override
	public ApiResponse createProduct(List<ProductDTO> products) throws Exception {
		ApiResponse response = new ApiResponse();
		try {
			List<Electronics> electronicsList = products.stream().map(ProductDTO::toElectronicsEntity)
					.collect(Collectors.toList());
			electronicsRepository.saveAll(electronicsList);
			response.setMessage(GlobalConstant.PRODUCT_CREATED);
		} catch (Exception e) {
			response.setMessage(GlobalConstant.PRODUCT_CREATION_FAILED);
		}
		return response;
	}

	@Override
	public ApiResponse updateProduct(Integer id, ProductDTO productDTO) {
		ApiResponse response = new ApiResponse();
		try {
			Electronics product = (Electronics) electronicsRepository.findById(id)
					.orElseThrow(() -> new Exception(GlobalConstant.NOT_FOUND + id));
			ProductDTO.updateData(product, productDTO);
			electronicsRepository.save(product);
			response.setMessage(GlobalConstant.UPDATE_SUCCESS);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
		}
		return response;
	}

}