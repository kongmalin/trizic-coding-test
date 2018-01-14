package com.trizic.coding.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AssetAllocationReqDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Valid
	@NotNull
	private String symbol;

	@Valid
	@NotNull
	@Min(0)
	@Max(100)
	private Long percentage;

	public AssetAllocationReqDto() {
		super();
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Long getPercentage() {
		return percentage;
	}

	public void setPercentage(Long percentage) {
		this.percentage = percentage;
	}

}
