package com.motadata.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.motadata.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}