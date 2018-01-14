package com.trizic.coding.test.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.trizic.coding.dao.IAdvisorDao;
import com.trizic.coding.dao.impl.AdvisorDaoImpl;
import com.trizic.coding.model.Advisor;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AdvisorDaoTest {

	@TestConfiguration
	static class AdvisorDaoTestContextConfiguration {
		@Bean
		public IAdvisorDao orderService() {
			return new AdvisorDaoImpl();
		}
	}

	@Autowired
	private IAdvisorDao advisorDaoImpl;

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
