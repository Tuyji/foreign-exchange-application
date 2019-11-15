package com.openpayd.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.openpayd.client.model.ExchangeRate;

@FeignClient(name = "latest", url = "http://data.fixer.io/api/latest")
public interface FixerApiFeignClient {
	
	@GetMapping
	public ResponseEntity<ExchangeRate> getExchangeRate(@RequestParam String access_key,
			@RequestParam String base,
			@RequestParam String symbols);
	
}
