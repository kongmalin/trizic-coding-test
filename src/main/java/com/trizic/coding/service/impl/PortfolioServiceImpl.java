package com.trizic.coding.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trizic.coding.dao.IPortfolioDao;
import com.trizic.coding.dto.service.AssetAllocationDto;
import com.trizic.coding.dto.service.PortfolioDto;
import com.trizic.coding.model.AssetAllocation;
import com.trizic.coding.model.Portfolio;
import com.trizic.coding.service.IPortfolioService;
import com.trizic.coding.util.Paging;

@Service
public class PortfolioServiceImpl implements IPortfolioService {

	@Autowired
	private IPortfolioDao portfolioDaoImpl;

	@Override
	@Transactional
	public PortfolioDto insertPortfolio(Portfolio portfolio) throws Exception {
		return convertFromDaoToDto(portfolioDaoImpl.save(portfolio));
	}

	@Override
	@Transactional
	public Paging findAll(Pageable pageable, String advisorId) {
		Page<Portfolio> page = portfolioDaoImpl.findAll(pageable, advisorId);
		Paging paging = new Paging();
		paging.setPageNumber(page.getNumber() + 1);
		paging.setPageSize(page.getSize());
		paging.setNumberOfPages(page.getTotalPages());
		paging.setTotalNumberOfElements(page.getTotalElements());
		paging.setPortfolioDtoList(getPageContent(page.getContent()));
		return paging;
	}

	private List<PortfolioDto> getPageContent(List<Portfolio> portfolioList) {
		List<PortfolioDto> portfolioDtoList = new ArrayList<>();
		for (Portfolio portfolio : portfolioList) {
			portfolioDtoList.add(convertFromDaoToDto(portfolio));
		}
		return portfolioDtoList;
	}

	private PortfolioDto convertFromDaoToDto(Portfolio portfolio) {
		PortfolioDto portfolioDto = null;
		if (portfolio != null) {
			portfolioDto = new PortfolioDto();
			portfolioDto.setGuid(portfolio.getAdvisor().getGuid());
			portfolioDto.setName(portfolio.getName());
			portfolioDto.setDescription(portfolio.getDescription());
			portfolioDto.setCashHoldingPercentage(portfolio.getCashHoldingPercentage());
			portfolioDto.setDriftPercentage(portfolio.getDriftPercentage());
			portfolioDto.setCreatedOn(new SimpleDateFormat("yyyy-MM-dd").format(portfolio.getCreatedOn()));
			portfolioDto.setModelType(portfolio.getModelType());
			portfolioDto.setRebalanceFrequency(portfolio.getRebalanceFrequency());
			portfolioDto.setAdvisorId(portfolio.getAdvisor().getAdvisorId());
			List<AssetAllocationDto> assetList = new ArrayList<>();
			for (AssetAllocation aa : portfolio.getAssetAllocationList())
				assetList.add(new AssetAllocationDto(aa.getSymbol(), aa.getPercentage()));
			portfolioDto.setAssetAllocations(assetList);
		}
		return portfolioDto;
	}

}
