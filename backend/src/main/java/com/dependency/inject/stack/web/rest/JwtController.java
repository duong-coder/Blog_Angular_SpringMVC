package com.dependency.inject.stack.web.rest;

import static com.dependency.inject.stack.common.ResourcesConstants.AUTHENTICATE_MAPPING;
import static com.dependency.inject.stack.common.ResourcesConstants.RESOURCE_API;
import static com.dependency.inject.stack.common.SecurityConstants.AUTHORIZATION_HEADER;
import static com.dependency.inject.stack.common.SecurityConstants.TOKEN_PREFIX;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dependency.inject.stack.config.jwt.TokenProvider;
import com.dependency.inject.stack.web.rest.vm.LoginVM;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.jsonwebtoken.impl.DefaultClaims;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * The type Jwt controller.
 */
@RestController
@RequestMapping(RESOURCE_API)
@Slf4j
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;
    
    @Autowired
    private PasswordEncoder pass;
    
    /**
     * Authorize response entity.
     *
     * @param loginVM the login vm
     * @return the response entity
     */
    @PostMapping(AUTHENTICATE_MAPPING)
    public ResponseEntity<JwtToken> authorize(@Valid @RequestBody LoginVM loginVM) {
//    	log.info("Username: " + loginVM.getPhone() + "; pass" + loginVM.getPassword() + "encode" + pass.matches("1234", "$2a$10$IDXaDhjrSSsbLPx9BqHvheodo8Yfex9dRxUmb7l77VD9ShveDL7vy"));
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginVM.getUsername(),loginVM.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        boolean rememberMe = (loginVM.getRememberMe() == null) ? false : loginVM.getRememberMe();
        String jwt = tokenProvider.createToken(authentication, rememberMe);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION_HEADER, TOKEN_PREFIX + jwt);

        log.info("Authenticated with token {}", jwt);

//        TwilioSms.sendMessage(loginVM.getUsername(), "Bạn vừa đăng nhập vào hệ thống HDHT Medical");

        return new ResponseEntity<>(new JwtToken(jwt), httpHeaders, HttpStatus.OK);
    }
    @GetMapping(value = "/refreshtoken")
	public ResponseEntity<JwtToken> refreshtoken(HttpServletRequest request) throws Exception {
		// From the HttpRequest get the claims
		DefaultClaims claims = (io.jsonwebtoken.impl.DefaultClaims) request.getAttribute("claims");

		Map<String, Object> expectedMap = getMapFromIoJsonwebtokenClaims(claims);
		String jwt = tokenProvider.doGenerateRefreshToken(expectedMap, expectedMap.get("sub").toString());
		
		HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION_HEADER, TOKEN_PREFIX + jwt);
        
		return new ResponseEntity<>(new JwtToken(jwt), httpHeaders, HttpStatus.OK);
	}

	public Map<String, Object> getMapFromIoJsonwebtokenClaims(DefaultClaims claims) {
		Map<String, Object> expectedMap = new HashMap<String, Object>();
		for (Entry<String, Object> entry : claims.entrySet()) {
			expectedMap.put(entry.getKey(), entry.getValue());
		}
		return expectedMap;
	}

    /**
     * Object to return as body in JWT Authentication.
     */
    @Data
    @AllArgsConstructor
    static class JwtToken {

        @JsonProperty("id_token")
        private String idToken;

    }

}