package com.openpayd.conversion.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.openpayd.conversion.model.Conversion;

public interface ConversionService {
	
	public Conversion createConversion(Conversion conversion);
	
	public Optional<Conversion> getConversionById(Long id);

	public Page<Conversion> getConversionByDate(LocalDate transactionDate, Integer pageNo, Integer pageSize);
	
}
