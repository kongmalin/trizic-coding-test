package com.trizic.coding.util;

import java.util.ArrayList;
import java.util.List;

import com.trizic.coding.dto.AssetAllocationReqDto;
import com.trizic.coding.dto.PortfolioReqDto;
import com.trizic.coding.model.Advisor;
import com.trizic.coding.model.AssetAllocation;
import com.trizic.coding.model.Portfolio;

public class InputValidation {

	public static Portfolio validatePortfolioDto(Advisor advisor, PortfolioReqDto portfolioReqDto) {
		Portfolio portfolio = new Portfolio();
		portfolio.setAdvisor(advisor);
		portfolio.setName(portfolioReqDto.getName());
		portfolio.setDescription(portfolioReqDto.getDescription());
		portfolio.setCashHoldingPercentage(portfolioReqDto.getCashHoldingPercentage());
		portfolio.setDriftPercentage(portfolioReqDto.getDriftPercentage());
		portfolio.setCreatedOn(portfolioReqDto.getCreatedOn());
		portfolio.setModelType(portfolioReqDto.getModelType());
		portfolio.setRebalanceFrequency(portfolioReqDto.getRebalanceFrequency());
		List<AssetAllocation> assetAllocationsList = new ArrayList<>();
		long totalPercentage = 0;
		totalPercentage = portfolioReqDto.getCashHoldingPercentage();
		for (AssetAllocationReqDto aa : portfolioReqDto.getAssetAllocationReqDtoList()) {
			totalPercentage += aa.getPercentage();
			AssetAllocation assetAllocation = new AssetAllocation();
			assetAllocation.setSymbol(aa.getSymbol());
			assetAllocation.setPercentage(aa.getPercentage());
			assetAllocation.setPortfolio(portfolio);
			assetAllocationsList.add(assetAllocation);
		}
		portfolio.setAssetAllocationList(assetAllocationsList);
		return totalPercentage != 100 ? null : portfolio;
	}

}
