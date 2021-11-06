package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SalesDTO;
import com.devsuperior.dsvendas.dto.SalesSuccessDTO;
import com.devsuperior.dsvendas.dto.SalesSumDTO;
import com.devsuperior.dsvendas.entities.Sales;
import com.devsuperior.dsvendas.services.SalesService;

@RestController
@RequestMapping(value = "/sales")
public class SalesController {

	@Autowired
	private SalesService service;
	
	@GetMapping()
	public ResponseEntity<Page<SalesDTO>> findAll(Pageable pageable) {
		Page<SalesDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SalesSumDTO>> amountGroupedBySeller() {
		List<SalesSumDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SalesSuccessDTO>> successGroupedBySeller() {
		List<SalesSuccessDTO> list = service.successGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	
}
