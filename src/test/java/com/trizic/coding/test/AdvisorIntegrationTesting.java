package com.trizic.coding.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trizic.coding.AdvisorApplication;
import com.trizic.coding.dto.service.AssetAllocationDto;
import com.trizic.coding.dto.service.PortfolioDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = AdvisorApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class AdvisorIntegrationTesting {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getPortfolioRecordsTest() {
		try {
			mvc.perform(get("/v1/advisor/e0fe83a1-7512-432f-ba66-d2ae677272c2/portfolio/1/10")
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$.page[0].name").value("Portfolio03"));
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
					.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
					.andExpect(jsonPath("$.guid").value("43f173ae-a17c-456e-8ccb-c69e1d61c437"));
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
