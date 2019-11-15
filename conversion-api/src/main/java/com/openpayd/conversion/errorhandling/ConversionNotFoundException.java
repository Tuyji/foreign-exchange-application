package com.openpayd.conversion.errorhandling;

public class ConversionNotFoundException extends RuntimeException {
	
	public ConversionNotFoundException(Long id) {
		super("Conversion not found : " + id);
	}
	
	public ConversionNotFoundException(String date) {
		super("No conversions found : " + date);
	}
}
