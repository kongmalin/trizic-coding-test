package com.trizic.coding.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trizic.coding.dao.IAdvisorDao;
import com.trizic.coding.model.Advisor;

@Repository
public class AdvisorDaoImpl implements IAdvisorDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Advisor getAdvisor(String advisorId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Advisor advisor = session.get(Advisor.class, advisorId);
		return advisor;
	}

}
