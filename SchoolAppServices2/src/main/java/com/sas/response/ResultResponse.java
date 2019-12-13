package com.sas.response;

import java.io.Serializable;

public class ResultResponse<T> implements Serializable {

	private static final long serialVersionUID = -2059537884304126346L;

	private int statusCode;
	private String statusMessage;
	private T data;

	public ResultResponse() {
		super();
	}

	public ResultResponse(int statusCode) {
		super();
		this.statusCode = statusCode;
	}

	public ResultResponse(int statusCode, String statusMessage) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	public ResultResponse(int statusCode, String statusMessage, T data) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.data = data;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}