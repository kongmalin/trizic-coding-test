package com.trizic.coding.test.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.trizic.coding.dao.IPortfolioDao;
import com.trizic.coding.model.Advisor;
import com.trizic.coding.model.AssetAllocation;
import com.trizic.coding.model.Portfolio;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PortfolioDaoTest {

	@Autowired
	private IPortfolioDao portfolioDaoImpl;

	@Test
	public void insertPortfolioTest() {
		try {
			Advisor advisor = new Advisor();
			advisor.setGuid("43f173ae-a17c-456e-8ccb-c69e1d61c437");
			advisor.setAdvisorId("e0fe83a1-7512-432f-ba66-d2ae677272c1");
			Portfolio portfolio = new Portfolio();
			portfolio.setAdvisor(advisor);
			portfolio.setName("example model 2");
			portfolio.setDescription("example model with tech stocks");
			portfolio.setCashHoldingPercentage(new Long(10));
			portfolio.setDriftPercentage(new Long(5));
			portfolio.setCreatedOn(new SimpleDateFormat("yyyy-MM-dd").parse("2017-03-01"));
			portfolio.setModelType("TAXABLE");
			portfolio.setRebalanceFrequency("ANNUAL");
			List<AssetAllocation> assetList = new ArrayList<>();
			assetList.add(new AssetAllocation("SYMBOL01", new Long(30), portfolio));
			assetList.add(new AssetAllocation("SYMBOL02", new Long(60), portfolio));
			portfolio.setAssetAllocationList(assetList);
			Portfolio persistedPortfolio = portfolioDaoImpl.save(portfolio);
			assertThat(persistedPortfolio.getAdvisor().getGuid()).isEqualTo("43f173ae-a17c-456e-8ccb-c69e1d61c437");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findAllTest() {
		Page<Portfolio> page = portfolioDaoImpl.findAll(new PageRequest(0, 10), "e0fe83a1-7512-432f-ba66-d2ae677272c2");
		assertThat(page.getContent().get(0).getAssetAllocationList().get(0).getSymbol()).isEqualTo("TEST01");
	}

}
