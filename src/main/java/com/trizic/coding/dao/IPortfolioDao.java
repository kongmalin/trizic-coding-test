package com.trizic.coding.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trizic.coding.model.Portfolio;

@Repository
public interface IPortfolioDao extends JpaRepository<Portfolio, String> {

	public Portfolio save(Portfolio portfolio);

	@Query("FROM Portfolio p WHERE p.advisor.advisorId = :advisorId")
	public Page<Portfolio> findAll(Pageable pageable, @Param("advisorId") String advisorId);

}
