package com.devsuperior.dsvendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SalesDTO;
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
	
}
