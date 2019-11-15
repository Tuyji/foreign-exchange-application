package com.openpayd.conversion.util;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.openpayd.conversion.model.Conversion;

public class ConversionBuilder {
	
	private Long transactionId = null;
	private String exchangeRate;
	private String source;
	private String target;
	private String amount;
	private String result;
	
	public static ConversionBuilder createInstance() {
		return new ConversionBuilder();
	}
	
	public ConversionBuilder setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	
	public ConversionBuilder setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
		return this;
	}
	
	public ConversionBuilder setSource(String source) {
		this.source = source;
		return this;
	}
	
	public ConversionBuilder setTarget(String target) {
		this.target = target;
		return this;
	}
	
	public ConversionBuilder setAmount(String amount) {
		this.amount = amount;
		return this;
	}
	
	public ConversionBuilder calculateResult() {
		this.result = new BigDecimal(this.exchangeRate)
				.multiply(new BigDecimal(this.amount))
				.toString();
		return this;
	}
	
	public Conversion build() {
		return new Conversion(this.transactionId, 
				this.source, 
				this.target, 
				this.exchangeRate, 
				this.amount, 
				this.result, 
				LocalDate.now());
	}
}
