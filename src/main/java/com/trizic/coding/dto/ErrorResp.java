package com.trizic.coding.dto;

import java.io.Serializable;

public class ErrorResp extends RespObj implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;

	public ErrorResp() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
