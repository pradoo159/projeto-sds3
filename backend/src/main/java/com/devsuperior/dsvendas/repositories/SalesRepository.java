package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.dto.SalesSuccessDTO;
import com.devsuperior.dsvendas.dto.SalesSumDTO;
import com.devsuperior.dsvendas.entities.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {
	
	@Query("SELECT new com.devsuperior.dsvendas.dto.SalesSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sales AS obj GROUP BY obj.seller")
	List<SalesSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.devsuperior.dsvendas.dto.SalesSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sales AS obj GROUP BY obj.seller")
	List<SalesSuccessDTO> successGroupedBySeller();
	
}
