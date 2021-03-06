package com.devsuperior.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SalesDTO;
import com.devsuperior.dsvendas.dto.SalesSuccessDTO;
import com.devsuperior.dsvendas.dto.SalesSumDTO;
import com.devsuperior.dsvendas.entities.Sales;
import com.devsuperior.dsvendas.repositories.SalesRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SalesService {

	@Autowired
	private SalesRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SalesDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sales> result = repository.findAll(pageable);
		return result.map(x -> new SalesDTO(x));
	}

	@Transactional(readOnly = true)
	public List<SalesSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SalesSuccessDTO> successGroupedBySeller() {
		return repository.successGroupedBySeller();
	}
	
}
