package com.openpayd.fx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openpayd.client.feign.FixerApiFeignClient;
import com.openpayd.client.model.ExchangeRate;
import com.openpayd.common.constants.CommonConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="exchangerate-api")
public class ExchangeRateController {
	
	@Autowired
	FixerApiFeignClient fixerApiClient;

	@ApiOperation(value = "Exhange Rate" , notes = "Get real-time exchange rate data requested currency pairs", response = ExchangeRate.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "source", value = "Source Currency", required = true, dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "target", value = "Target Currency", required = true, dataType = "string", paramType = "query") })
	@GetMapping
	public ResponseEntity<ExchangeRate> getExchangeRate(@RequestParam(required = true) String source,
			@RequestParam(required = true) String target) {
		
		ResponseEntity<ExchangeRate> exchangeRateEn = fixerApiClient.getExchangeRate(CommonConstants.FIXER_IO_ACCESS_KEY.getConstant(), 
				source, target);
		
		ExchangeRate exchangeRate = exchangeRateEn.getBody();
		return new ResponseEntity<ExchangeRate>(exchangeRate, HttpStatus.OK);
	}
}
