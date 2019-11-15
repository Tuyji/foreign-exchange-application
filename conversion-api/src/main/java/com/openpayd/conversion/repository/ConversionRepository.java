package com.openpayd.conversion.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openpayd.conversion.model.Conversion;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion, Long>{
	Page<Conversion> findAllByTransactionDate(LocalDate transactionDate, Pageable pageable);
}
