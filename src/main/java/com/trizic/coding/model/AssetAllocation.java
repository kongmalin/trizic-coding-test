package com.trizic.coding.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AssetAllocation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String symbol;

	private Long percentage;

	@ManyToOne
	@JoinColumn(name = "name", nullable = false)
	private Portfolio portfolio;

	public AssetAllocation() {
		super();
	}

	public AssetAllocation(String symbol, Long percentage, Portfolio portfolio) {
		super();
		this.symbol = symbol;
		this.percentage = percentage;
		this.portfolio = portfolio;
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

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

}
