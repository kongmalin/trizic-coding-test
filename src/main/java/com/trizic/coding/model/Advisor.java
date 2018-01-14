package com.trizic.coding.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;

@Entity
public class Advisor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String advisorId;

	private String guid;

	@OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Portfolio> portfolioList;

	public Advisor() {
		super();
	}

	public String getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(String advisorId) {
		this.advisorId = advisorId;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public List<Portfolio> getPortfolioList() {
		return portfolioList;
	}

	public void setPortfolioList(List<Portfolio> portfolioList) {
		this.portfolioList = portfolioList;
	}

}
