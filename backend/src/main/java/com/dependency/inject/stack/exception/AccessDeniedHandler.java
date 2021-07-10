package com.dependency.inject.stack.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

@Component
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler{
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
//		Response apiResponse = new Response("Access Denied", 403, null);
//		OutputStream outputStream = response.getOutputStream();
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.writeValue(outputStream, apiResponse);
//		outputStream.flush();
//		
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
	}
}
