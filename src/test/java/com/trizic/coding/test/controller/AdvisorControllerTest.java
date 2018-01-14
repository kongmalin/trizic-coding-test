package com.trizic.coding.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trizic.coding.controller.AdvisorController;
import com.trizic.coding.dto.service.AssetAllocationDto;
import com.trizic.coding.dto.service.PortfolioDto;
import com.trizic.coding.service.IAdvisorService;
import com.trizic.coding.service.IPortfolioService;
import com.trizic.coding.util.Paging;

@RunWith(SpringRunner.class)
@WebMvcTest(AdvisorController.class)
public class AdvisorControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private IAdvisorService advisorServiceImpl;

	@MockBean
	private IPortfolioService portfolioServiceImpl;

	@MockBean
	private SessionFactory sessionFactory;

	@Before
	public void init() {
		Paging paging = new Paging();
		paging.setNumberOfPages(1);
		paging.setPageSize(10);
		paging.setPageNumber(1);
		paging.setTotalNumberOfElements(new Long(2));
		List<PortfolioDto> list = new ArrayList<>();
		List<AssetAllocationDto> assetList = new ArrayList<>();
		assetList.add(new AssetAllocationDto("TEST01", new Long(20)));
		assetList.add(new AssetAllocationDto("TEST02", new Long(25)));
		assetList.add(new AssetAllocationDto("TEST03", new Long(5)));
		assetList.add(new AssetAllocationDto("TEST04", new Long(5)));
		assetList.add(new AssetAllocationDto("TEST05", new Long(30)));
		list.add(new PortfolioDto("43f173ae-a17c-456e-8ccb-c69e1d61c438", "Portfolio03",
				"example model with tech stocks 03", new Long(5), new Long(15), "2017-10-02", "TAXABLE", "ANNUAL",
				"e0fe83a1-7512-432f-ba66-d2ae677272c2", assetList));
		paging.setPortfolioDtoList(list);
		Mockito.when(portfolioServiceImpl.findAll(new PageRequest(0, 10), "e0fe83a1-7512-432f-ba66-d2ae677272c2"))
				.thenReturn(paging);
	}

	@Test
	public void getPortfolioRecordsTest() {
		try {
			mvc.perform(get("/v1/advisor/e0fe83a1-7512-432f-ba66-d2ae677272c2/portfolio/1/10")
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andExpect(jsonPath("$.page[0].name").value("Portfolio03"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void addPortfolioToAdvisorTest() {
		PortfolioDto portfolioDto = new PortfolioDto();
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

		try {
			mvc.perform(post("/v1/advisor/e0fe83a1-7512-432f-ba66-d2ae677272c1/portfolio")
					.content(asJsonString(portfolioDto)).contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
