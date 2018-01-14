package com.trizic.coding.dto.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.trizic.coding.dto.RespObj;

public class PortfolioDto extends RespObj implements Serializable {

	private static final long serialVersionUID = 1L;

	private String guid;
	private String name;
	private String description;
	private Long cashHoldingPercentage;
	private Long driftPercentage;
	private String createdOn;
	private String modelType;
	private String rebalanceFrequency;
	private String advisorId;
	private List<AssetAllocationDto> assetAllocations;

	public PortfolioDto() {
		super();
	}

	public PortfolioDto(String guid, String name, String description, Long cashHoldingPercentage, Long driftPercentage,
			String createdOn, String modelType, String rebalanceFrequency, String advisorId,
			List<AssetAllocationDto> assetAllocations) {
		super();
		this.guid = guid;
		this.name = name;
		this.description = description;
		this.cashHoldingPercentage = cashHoldingPercentage;
		this.driftPercentage = driftPercentage;
		this.createdOn = createdOn;
		this.modelType = modelType;
		this.rebalanceFrequency = rebalanceFrequency;
		this.advisorId = advisorId;
		this.assetAllocations = assetAllocations;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCashHoldingPercentage() {
		return cashHoldingPercentage;
	}

	public void setCashHoldingPercentage(Long cashHoldingPercentage) {
		this.cashHoldingPercentage = cashHoldingPercentage;
	}

	public Long getDriftPercentage() {
		return driftPercentage;
	}

	public void setDriftPercentage(Long driftPercentage) {
		this.driftPercentage = driftPercentage;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public String getRebalanceFrequency() {
		return rebalanceFrequency;
	}

	public void setRebalanceFrequency(String rebalanceFrequency) {
		this.rebalanceFrequency = rebalanceFrequency;
	}

	public String getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(String advisorId) {
		this.advisorId = advisorId;
	}

	public List<AssetAllocationDto> getAssetAllocations() {
		return assetAllocations;
	}

	public void setAssetAllocations(List<AssetAllocationDto> assetAllocations) {
		this.assetAllocations = assetAllocations;
	}

}
