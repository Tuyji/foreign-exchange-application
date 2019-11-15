package com.openpayd.common.constants;

public enum CommonConstants {
	FIXER_IO_URI("http://data.fixer.io/api/latest"),
	FIXER_IO_ACCESS_KEY("c880fdce6882caaf1f435156450799d5");
	
	private String constant;
	 
	CommonConstants(String constant) {
        this.constant = constant;
    }

	public String getConstant() {
		return constant;
	}
	
}
