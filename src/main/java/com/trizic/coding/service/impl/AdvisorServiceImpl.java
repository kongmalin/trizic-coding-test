package com.trizic.coding.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trizic.coding.dao.IAdvisorDao;
import com.trizic.coding.model.Advisor;
import com.trizic.coding.service.IAdvisorService;

@Service
public class AdvisorServiceImpl implements IAdvisorService {

	@Autowired
	private IAdvisorDao advisorDaoImpl;

	@Override
	@Transactional
	public Advisor getAdvisor(String advisorId) throws Exception {
		return advisorDaoImpl.getAdvisor(advisorId);
	}

}
