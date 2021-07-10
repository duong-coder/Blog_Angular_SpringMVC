package com.dependency.inject.stack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dependency.inject.stack.web.response.Response;

import io.jsonwebtoken.ExpiredJwtException;

@ControllerAdvice
public class AuthenticateAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = ExpiredJwtException.class)
	public ResponseEntity<Response> unAuthenticate(Exception ex, WebRequest request){
		Response response = new Response("Token is Expired", 401, null);
		
		return new ResponseEntity<Response>(response, HttpStatus.UNAUTHORIZED);
	}
}
