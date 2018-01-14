package com.trizic.coding.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Portfolio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String name;

	private String description;

	private Long cashHoldingPercentage;

	private Long driftPercentage;

	private Date createdOn;

	private String modelType;

	private String rebalanceFrequency;

	@ManyToOne
	@JoinColumn(name = "advisorId", nullable = false)
	private Advisor advisor;

	@OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<AssetAllocation> assetAllocationList;

	public Portfolio() {
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

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	public List<AssetAllocation> getAssetAllocationList() {
		return assetAllocationList;
	}

	public void setAssetAllocationList(List<AssetAllocation> assetAllocationList) {
		this.assetAllocationList = assetAllocationList;
	}

}
