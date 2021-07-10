package com.dependency.inject.stack.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class AuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
//		Response apiResponse = new Response("Unauthorized. Token is expired", 401, null);
//		OutputStream outputStream = response.getOutputStream();
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.writeValue(outputStream, apiResponse);
//		outputStream.flush();

		Object ex = request.getAttribute("exception");
		if(ex != null || ex instanceof ExpiredJwtException) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized. Token is expired");
			return;
		}
		
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied");

	}

}
