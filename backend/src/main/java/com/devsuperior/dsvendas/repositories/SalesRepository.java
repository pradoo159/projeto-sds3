package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvendas.entities.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {
	
}
