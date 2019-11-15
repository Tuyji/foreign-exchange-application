package com.openpayd.conversion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.openpayd.conversion.model.Conversion;
import com.openpayd.conversion.repository.ConversionRepository;
import com.openpayd.conversion.service.ConversionServiceImpl;
import com.openpayd.conversion.util.ConversionBuilder;

@RunWith(MockitoJUnitRunner.class)
public class ConversionServiceTest {

	private final int PAGE_NUMBER = 0;
	private final int PAGE_SIZE = 1;

	@Mock
	ConversionRepository repository;

	@InjectMocks
	ConversionServiceImpl service;

	@Test
	public void createConversionTest() {
		Conversion conversion = ConversionBuilder.createInstance()
				.setTransactionId(1L)
				.setSource("EUR")
				.setTarget("TRY")
				.setExchangeRate("6.35")
				.setAmount("20")
				.calculateResult()
				.build();

		when(repository.save(any(Conversion.class))).thenReturn(conversion);

		Conversion created = service.createConversion(conversion);

		assertThat(created.getSource()).isSameAs(conversion.getSource());

	}

	@Test
	public void testFindConversionById() {
		Conversion conversion = ConversionBuilder.createInstance()
				.setTransactionId(1L)
				.setSource("EUR")
				.setTarget("TRY")
				.setExchangeRate("6.35")
				.setAmount("20")
				.calculateResult()
				.build();

		when(repository.findById(1L)).thenReturn(Optional.of(conversion));

		Optional<Conversion> actualConversion = service.getConversionById(1L);

		assertThat(actualConversion.get()).isEqualTo(conversion);
	}

	@Test
	public void testFindConversionsByDate() {
		Conversion conversion = ConversionBuilder.createInstance()
				.setTransactionId(1L)
				.setSource("EUR")
				.setTarget("TRY")
				.setExchangeRate("6.35")
				.setAmount("20")
				.calculateResult()
				.build();

		List<Conversion> conversionSingleList = Arrays.asList(conversion);

		Pageable pageRequest = PageRequest.of(PAGE_NUMBER, PAGE_SIZE);

		Page<Conversion> pageConversions = new PageImpl<Conversion>(conversionSingleList, pageRequest, 1);

		when(repository.findAllByTransactionDate(LocalDate.now(), pageRequest)).thenReturn(pageConversions);
		
		Page<Conversion> conversionByDate = service.getConversionByDate(LocalDate.now(), PAGE_NUMBER, PAGE_SIZE);
		
		assertThat(conversionByDate.stream().findFirst().get())
		.isEqualTo(pageConversions.stream().findFirst().get());
		
	}

}