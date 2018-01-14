package com.trizic.coding.service;

import org.springframework.data.domain.Pageable;

import com.trizic.coding.dto.service.PortfolioDto;
import com.trizic.coding.model.Portfolio;
import com.trizic.coding.util.Paging;

public interface IPortfolioService {

	public PortfolioDto insertPortfolio(Portfolio portfolio) throws Exception;

	public Paging findAll(Pageable pageable, String advisorId);

}
