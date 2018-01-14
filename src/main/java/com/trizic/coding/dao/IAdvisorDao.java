package com.trizic.coding.dao;

import com.trizic.coding.model.Advisor;

public interface IAdvisorDao {

	public Advisor getAdvisor(String advisorId) throws Exception;

}
