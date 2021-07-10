package com.dependency.inject.stack.config.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class CORSFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpResponse = ((HttpServletResponse) response);
		String headerACAO = httpResponse.getHeader("Access-Control-Allow-Origin");
		if (headerACAO == null) {
			httpResponse.addHeader("Access-Control-Allow-Origin", "*");
		}
		
		chain.doFilter(request, response);
	}

}
