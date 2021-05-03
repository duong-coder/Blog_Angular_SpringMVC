package com.dependency.inject.stack.config.jwt;


import com.dependency.inject.stack.common.SecurityConstants;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * The type Jwt filter.
 */
@Slf4j
public class JwtFilter extends GenericFilterBean {

    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    private PasswordEncoder pass;
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        
        try {
			// JWT Token is in the form "Bearer token". Remove Bearer word and
			// get only the Token

			String jwt = resolveToken(httpServletRequest);
	        System.out.println("jwt" + jwt);
	        if (StringUtils.hasText(jwt) && this.tokenProvider.validateToken(jwt)) {
	            Authentication authentication = this.tokenProvider.getAuthentication(jwt);
	            SecurityContextHolder.getContext().setAuthentication(authentication);
	            log.info(jwt);
	            log.info(authentication.toString());
	        } else {
				System.out.println("Cannot set the Security Context");
				
			}
		} catch (ExpiredJwtException ex) {

			String isRefreshToken = httpServletRequest.getHeader("isRefreshToken");
			String requestURL = httpServletRequest.getRequestURL().toString();
			// allow for Refresh Token creation if following conditions are true.
			if (isRefreshToken != null && isRefreshToken.equals("true") && requestURL.contains("refreshtoken")) {
				allowForRefreshToken(ex, httpServletRequest);
			} else {
				httpServletRequest.setAttribute("exception", ex);
			}
		} catch (BadCredentialsException ex) {
			httpServletRequest.setAttribute("exception", ex);
		} catch (Exception ex) {
			System.out.println(ex);
		}
        filterChain.doFilter(servletRequest, servletResponse);
    }
    
    private void allowForRefreshToken(ExpiredJwtException ex, HttpServletRequest request) {

		// create a UsernamePasswordAuthenticationToken with null values.
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				null, null, null);
		// After setting the Authentication in the context, we specify
		// that the current user is authenticated. So it passes the
		// Spring Security Configurations successfully.
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		// Set the claims so that in controller we will be using it to create
		// new JWT
		request.setAttribute("claims", ex.getClaims());

	}
    
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(SecurityConstants.AUTHORIZATION_HEADER);
        System.out.println("token" + bearerToken);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            return bearerToken.substring(7);
        }
        return null;
    }

}
