package com.trizic.coding.dto.service;

import java.io.Serializable;

public class AssetAllocationDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String symbol;
	private Long percentage;

	public AssetAllocationDto() {
		super();
	}

	public AssetAllocationDto(String symbol, Long percentage) {
		super();
		this.symbol = symbol;
		this.percentage = percentage;
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
