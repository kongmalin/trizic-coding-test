package com.trizic.coding.test.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.trizic.coding.dao.IPortfolioDao;
import com.trizic.coding.dto.service.AssetAllocationDto;
import com.trizic.coding.dto.service.PortfolioDto;
import com.trizic.coding.model.Portfolio;
import com.trizic.coding.service.IPortfolioService;
import com.trizic.coding.service.impl.PortfolioServiceImpl;
import com.trizic.coding.util.Paging;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PortfolioServiceTest {

	@TestConfiguration
	static class AdvisorServiceTestContextConfiguration {
		@Bean
		public IPortfolioService portfolioService() {
			return new PortfolioServiceImpl();
		}
	}

	@Autowired
	private IPortfolioService portfolioServiceImpl;

	@Autowired
	private IPortfolioDao portfolioDaoImpl;

	@Before
	public void init() {
		try {
			PortfolioDto portfolioDto = new PortfolioDto();
			portfolioDto.setAdvisorId("e0fe83a1-7512-432f-ba66-d2ae677272c1");
			portfolioDto.setGuid("43f173ae-a17c-456e-8ccb-c69e1d61c437");
			portfolioDto.setName("example model 2");
			portfolioDto.setDescription("example model with tech stocks");
			portfolioDto.setCashHoldingPercentage(new Long(10));
			portfolioDto.setDriftPercentage(new Long(5));
			portfolioDto.setCreatedOn("2017-03-01");
			portfolioDto.setModelType("TAXABLE");
			portfolioDto.setRebalanceFrequency("ANNUAL");
			List<AssetAllocationDto> assetList = new ArrayList<>();
			assetList.add(new AssetAllocationDto("SYMBOL01", new Long(30)));
			assetList.add(new AssetAllocationDto("SYMBOL02", new Long(60)));
			portfolioDto.setAssetAllocations(assetList);
			Mockito.when(portfolioServiceImpl.insertPortfolio(new Portfolio())).thenReturn(portfolioDto);

			Paging paging = new Paging();
			paging.setNumberOfPages(1);
			paging.setPageSize(10);
			paging.setPageNumber(1);
			paging.setTotalNumberOfElements(new Long(2));
			List<PortfolioDto> list = new ArrayList<>();
			List<AssetAllocationDto> assetDtoList = new ArrayList<>();
			assetDtoList.add(new AssetAllocationDto("TEST01", new Long(20)));
			assetDtoList.add(new AssetAllocationDto("TEST02", new Long(25)));
			assetDtoList.add(new AssetAllocationDto("TEST03", new Long(5)));
			assetDtoList.add(new AssetAllocationDto("TEST04", new Long(5)));
			assetDtoList.add(new AssetAllocationDto("TEST05", new Long(30)));
			list.add(new PortfolioDto("43f173ae-a17c-456e-8ccb-c69e1d61c438", "Portfolio03",
					"example model with tech stocks 03", new Long(5), new Long(15), "2017-10-02", "TAXABLE", "ANNUAL",
					"e0fe83a1-7512-432f-ba66-d2ae677272c2", assetDtoList));
			paging.setPortfolioDtoList(list);
			Mockito.when(portfolioServiceImpl.findAll(new PageRequest(0, 10), "e0fe83a1-7512-432f-ba66-d2ae677272c2"))
					.thenReturn(paging);
			Page<Portfolio> page = portfolioDaoImpl.findAll(new PageRequest(0, 10),
					"e0fe83a1-7512-432f-ba66-d2ae677272c2");
			Mockito.when(portfolioDaoImpl.findAll(new PageRequest(0, 10), "e0fe83a1-7512-432f-ba66-d2ae677272c2"))
					.thenReturn(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertPortfolioTest() {
		try {
			PortfolioDto portfolioDtoPersisted = portfolioServiceImpl.insertPortfolio(new Portfolio());
			assertThat(portfolioDtoPersisted.getGuid()).isEqualTo("43f173ae-a17c-456e-8ccb-c69e1d61c437");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findAllTest() {
		Paging paging = portfolioServiceImpl.findAll(new PageRequest(0, 10), "e0fe83a1-7512-432f-ba66-d2ae677272c2");
		assertThat(paging.getPortfolioDtoList().get(0).getAssetAllocations().get(0).getSymbol()).isEqualTo("TEST01");
	}

}
