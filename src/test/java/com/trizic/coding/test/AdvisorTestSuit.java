package com.trizic.coding.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.trizic.coding.test.controller.AdvisorControllerTest;
import com.trizic.coding.test.dao.AdvisorDaoTest;
import com.trizic.coding.test.dao.PortfolioDaoTest;
import com.trizic.coding.test.service.AdvisorServiceTest;
import com.trizic.coding.test.service.PortfolioServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ AdvisorControllerTest.class, AdvisorDaoTest.class, AdvisorServiceTest.class,
		PortfolioDaoTest.class, PortfolioServiceTest.class, AdvisorIntegrationTesting.class })
public class AdvisorTestSuit {

}
