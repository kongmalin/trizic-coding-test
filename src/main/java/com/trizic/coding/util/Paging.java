package com.trizic.coding.util;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trizic.coding.dto.RespObj;
import com.trizic.coding.dto.service.PortfolioDto;

public class Paging extends RespObj implements Serializable {

	private static final long serialVersionUID = 1L;

	private int pageNumber;

	private int pageSize;

	private int numberOfPages;

	private Long totalNumberOfElements;

	@JsonProperty("page")
	private List<PortfolioDto> portfolioDtoList;

	public Paging() {
		super();
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public Long getTotalNumberOfElements() {
		return totalNumberOfElements;
	}

	public void setTotalNumberOfElements(Long totalNumberOfElements) {
		this.totalNumberOfElements = totalNumberOfElements;
	}

	public List<PortfolioDto> getPortfolioDtoList() {
		return portfolioDtoList;
	}

	public void setPortfolioDtoList(List<PortfolioDto> portfolioDtoList) {
		this.portfolioDtoList = portfolioDtoList;
	}

}
