package com.yogi.api.dto;

/**
* Created by Krishan Shukla on 20/10/2017.7
*/

public class BaseResponseDto<T> {
	T result;
	String status;
	String message;

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
