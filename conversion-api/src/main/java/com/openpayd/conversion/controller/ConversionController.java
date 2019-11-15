package com.openpayd.conversion.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openpayd.client.feign.FixerApiFeignClient;
import com.openpayd.client.model.ExchangeRate;
import com.openpayd.common.constants.CommonConstants;
import com.openpayd.conversion.errorhandling.ConversionNotFoundException;
import com.openpayd.conversion.model.Conversion;
import com.openpayd.conversion.service.ConversionService;
import com.openpayd.conversion.util.ConversionBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="conversions-api")
public class ConversionController {
	
	@Autowired
	FixerApiFeignClient fixerApiClient;
	
	@Autowired
	ConversionService service;

	@ApiOperation(value = "Convert Currencies" , notes = "Used to convert any amount from one currency to another.", 
			response = Conversion.class)
	@PostMapping
	public Conversion convert(@RequestBody Conversion request) {
		
		ExchangeRate exchangeRate = fixerApiClient.getExchangeRate(CommonConstants.FIXER_IO_ACCESS_KEY.getConstant(),
				request.getSource(), request.getTarget()).getBody();
		
		Conversion conversion = ConversionBuilder.createInstance()
				.setSource(request.getSource())
				.setTarget(request.getTarget())
				.setExchangeRate(exchangeRate.getRates().get(request.getTarget()))
				.setAmount(request.getAmount())
				.calculateResult()
				.build();
		
		return service.createConversion(conversion);
	}
	
	@ApiOperation(value = "Get Conversion by Id" , notes = "Get conversion by requested id.", 
			response = Conversion.class)
	@GetMapping(value="/id/{id}")
	public Conversion getConversionListById(@PathVariable(value = "id") 
	Long transactionId) {
		return service.getConversionById(transactionId)
				.orElseThrow(() -> new ConversionNotFoundException(transactionId));
	}

	@ApiOperation(value = "Get Conversion by Date" , notes = "Get list of filtered conversions by date.", 
			response = Conversion.class)
	@GetMapping
	public Page<Conversion> getConversionListByDate(@RequestParam(value = "date") String transactionDate,
	@RequestParam(value = "pageNo", defaultValue = "0") String pageNo, 
    @RequestParam(value = "pageSize", defaultValue = "10") String pageSize) {
		
		LocalDate date = LocalDate.parse(transactionDate);
		return service.getConversionByDate(date, Integer.valueOf(pageNo), 
				Integer.valueOf(pageSize));
	}
}
