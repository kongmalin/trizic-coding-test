package com.trizic.coding.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trizic.coding.util.ValidateString;

public class PortfolioReqDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Valid
	@NotNull
	private String name;

	@Valid
	@NotNull
	private String description;

	@Valid
	@NotNull
	@Min(0)
	@Max(100)
	private Long cashHoldingPercentage;

	@Valid
	@NotNull
	@Min(0)
	@Max(100)
	private Long driftPercentage;

	@Valid
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Los_Angeles")
	private Date createdOn;

	@Valid
	@NotNull
	@ValidateString(acceptedValues = { "QUALIFIED", "TAXABLE" }, message = "Model type must be QUALIFIED/TAXABLE.")
	private String modelType;

	@Valid
	@NotNull
	@ValidateString(acceptedValues = { "MONTHLY", "QUARTERLY", "SEMI_ANNUAL",
			"ANNUAL" }, message = "Rebalance frequency must be MONTHLY/QUARTERLY/SEMI_ANNUAL/ANNUAL.")
	private String rebalanceFrequency;

	@Valid
	@NotNull
	@JsonProperty("assetAllocations")
	private List<AssetAllocationReqDto> assetAllocationReqDtoList;

	public PortfolioReqDto() {
		super();
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
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

	public List<AssetAllocationReqDto> getAssetAllocationReqDtoList() {
		return assetAllocationReqDtoList;
	}

	public void setAssetAllocationReqDtoList(List<AssetAllocationReqDto> assetAllocationReqDtoList) {
		this.assetAllocationReqDtoList = assetAllocationReqDtoList;
	}

}
