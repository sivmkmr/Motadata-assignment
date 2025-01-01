package com.motadata;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.motadata.dao.repository.ProductRepository;
import com.motadata.entity.Electronics;
import com.motadata.entity.Product;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MotadataApplication {

//	@Autowired
//	private ProductRepository repository;
//
//	@PostConstruct
//	public void initDB() {
//	    List<Product> products = Stream.of(
//	            new Electronics("Dell XPS 13", 129999.99f, 30, "Electronics", "Dell", "XPS 13", 24),
//	            new Electronics("MacBook Pro 16", 249999.99f, 20, "Electronics", "Apple", "MacBook Pro 16", 36),
//	            new Electronics("HP Spectre x360", 119999.99f, 15, "Electronics", "HP", "Spectre x360", 12),
//	            new Electronics("Lenovo ThinkPad X1 Carbon", 134999.99f, 25, "Electronics", "Lenovo", "ThinkPad X1 Carbon", 36),
//	            new Electronics("Asus ROG Zephyrus G14", 149999.99f, 18, "Electronics", "Asus", "ROG Zephyrus G14", 24),
//	            new Electronics("Microsoft Surface Laptop 4", 159999.99f, 22, "Electronics", "Microsoft", "Surface Laptop 4", 24),
//	            new Electronics("Razer Blade 15", 189999.99f, 10, "Electronics", "Razer", "Blade 15", 36),
//	            new Electronics("Acer Predator Helios 300", 129999.99f, 16, "Electronics", "Acer", "Predator Helios 300", 12),
//	            new Electronics("Alienware m15 R6", 219999.99f, 12, "Electronics", "Dell", "Alienware m15 R6", 24)
//	    ).collect(Collectors.toList());
//
//	    repository.saveAll(products);
//	}

	public static void main(String[] args) {
		SpringApplication.run(MotadataApplication.class, args);
	}
}
