package com.dependency.inject.stack.web.response;

import lombok.Data;

@Data
public class Response {
	private String message;
	private int status;
	private Object body;
	
	public Response (String mess, int status, Object body) {
		this.message = mess;
		this.status = status;
		this.body = body;
	}
}
