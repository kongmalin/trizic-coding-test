package com.trizic.coding.test.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.trizic.coding.dao.IAdvisorDao;
import com.trizic.coding.model.Advisor;
import com.trizic.coding.service.IAdvisorService;
import com.trizic.coding.service.impl.AdvisorServiceImpl;

@RunWith(SpringRunner.class)
public class AdvisorServiceTest {

	@TestConfiguration
	static class AdvisorServiceTestContextConfiguration {
		@Bean
		public IAdvisorService orderService() {
			return new AdvisorServiceImpl();
		}
	}

	@Autowired
	private IAdvisorService advisorServiceImpl;

	@MockBean
	private IAdvisorDao advisorDaoImpl;

	@Before
	public void init() {
		Advisor advisor = new Advisor();
		advisor.setGuid("43f173ae-a17c-456e-8ccb-c69e1d61c437");
		advisor.setAdvisorId("e0fe83a1-7512-432f-ba66-d2ae677272c1");
		try {
			Mockito.when(advisorDaoImpl.getAdvisor("e0fe83a1-7512-432f-ba66-d2ae677272c1")).thenReturn(advisor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getAdvisorTest() {
		try {
			Advisor advisor = advisorDaoImpl.getAdvisor("e0fe83a1-7512-432f-ba66-d2ae677272c1");
			assertThat(advisor.getGuid()).isEqualTo("43f173ae-a17c-456e-8ccb-c69e1d61c437");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
