package com.trizic.coding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trizic.coding.dto.ErrorResp;
import com.trizic.coding.dto.PortfolioReqDto;
import com.trizic.coding.dto.RespObj;
import com.trizic.coding.dto.service.PortfolioDto;
import com.trizic.coding.model.Advisor;
import com.trizic.coding.model.Portfolio;
import com.trizic.coding.service.IAdvisorService;
import com.trizic.coding.service.IPortfolioService;
import com.trizic.coding.util.InputValidation;
import com.trizic.coding.util.Paging;

@RestController
public class AdvisorController {

	@Autowired
	private IAdvisorService advisorServiceImpl;

	@Autowired
	private IPortfolioService portfolioServiceImpl;

	@GetMapping(value = "/v1/advisor/{advisorId}/portfolio/{pageNumber}/{pageSize}", headers = "Accept="
			+ MediaType.APPLICATION_JSON_VALUE, consumes = {
					MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<RespObj> getPortfolioRecords(@PathVariable String advisorId, @PathVariable int pageNumber,
			@PathVariable int pageSize) {
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize);
		Paging paging = portfolioServiceImpl.findAll(pageable, advisorId);
		if (paging.getPortfolioDtoList().size() == 0)
			return generateResponse("No record found for advisor id: " + advisorId + ".", HttpStatus.OK);
		return new ResponseEntity<RespObj>(paging, HttpStatus.OK);
	}

	@PostMapping(value = "/v1/advisor/{advisorId}/portfolio", headers = "Accept="
			+ MediaType.APPLICATION_JSON_VALUE, consumes = {
					MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<RespObj> addPortfolioToAdvisor(@PathVariable String advisorId,
			@Validated @RequestBody PortfolioReqDto portfolioReqDto, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			StringBuilder errorMessage = new StringBuilder();
			for (Object object : result.getAllErrors()) {
				if (object instanceof FieldError) {
					FieldError fieldError = (FieldError) object;
					errorMessage.append(fieldError.getDefaultMessage());
				}
			}
			return generateResponse(errorMessage.toString(), HttpStatus.BAD_REQUEST);
		}

		Advisor advisor = advisorServiceImpl.getAdvisor(advisorId);
		if (advisor == null) {
			return generateResponse("Cannot find adivsor " + advisorId + ".", HttpStatus.OK);
		}

		// Validation for sum of percentage
		Portfolio portfolio = InputValidation.validatePortfolioDto(advisor, portfolioReqDto);
		if (portfolio == null) {
			return generateResponse("Total percentage is not 100%.", HttpStatus.BAD_REQUEST);
		}

		PortfolioDto portfolioDto = portfolioServiceImpl.insertPortfolio(portfolio);
		return new ResponseEntity<RespObj>(portfolioDto, HttpStatus.OK);
	}

	private ResponseEntity<RespObj> generateResponse(String errorMessage, HttpStatus httpStatus) {
		ErrorResp respObject = new ErrorResp();
		respObject.setMessage(errorMessage);
		return new ResponseEntity<RespObj>(respObject, httpStatus);
	}

}
