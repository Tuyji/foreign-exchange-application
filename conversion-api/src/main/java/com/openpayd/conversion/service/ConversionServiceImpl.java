package com.openpayd.conversion.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.openpayd.conversion.model.Conversion;
import com.openpayd.conversion.repository.ConversionRepository;

@Service
public class ConversionServiceImpl implements ConversionService {

	@Autowired
	public ConversionRepository repository;

	public Conversion createConversion(Conversion conversion){
		return repository.save(conversion);
	}

	public Optional<Conversion> getConversionById(Long id) {
		return repository.findById(id);
	}

	public Page<Conversion> getConversionByDate(LocalDate transactionDate, Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		return repository.findAllByTransactionDate(transactionDate, paging);
	}
	
}
