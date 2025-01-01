package com.motadata.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.motadata.entity.Electronics;

public interface ElectronicsRepository extends JpaRepository<Electronics, Integer> {

}