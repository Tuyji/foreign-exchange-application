package com.openpayd.conversion.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "conversion")
@Table(name = "conversion")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Conversion {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long transactionId;
	@ApiModelProperty(required = true, dataType = "java.lang.String", notes = "Three-letter currency code of the base currency.")
	private String source;
	@ApiModelProperty(required = true, dataType = "java.lang.String", notes = "Three-letter currency code of the target currency.")
	private String target;
	@ApiModelProperty(dataType = "java.lang.String", notes = "Currency rate of conversion.")
	private String rate;
	@ApiModelProperty(dataType = "java.lang.String", notes = "The amount to be converted.")
	private String amount;
	@ApiModelProperty(dataType = "java.lang.String", notes = "Returns the conversion result.")
	private String result;
	@ApiModelProperty(notes = "Transaction date of conversion.")
	private LocalDate transactionDate;
	
}
