//package com.dependency.inject.stack.web.rest;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.twilio.Twilio;
//import com.twilio.converter.Promoter;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//import com.dependency.inject.stack.common.SecurityConstants;
//import com.dependency.inject.stack.common.TwilioSms;
//import com.dependency.inject.stack.config.jwt.TokenProvider;
//import com.dependency.inject.stack.web.rest.vm.LoginVM;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//
//import java.net.URI;
//
//import static com.dependency.inject.stack.common.ResourcesConstants.*;
//import static com.dependency.inject.stack.common.SecurityConstants.*;
//
///**
// * The type Jwt controller.
// */
//@RestController
//@RequestMapping(RESOURCE_API)
//@Slf4j
//public class JwtController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private TokenProvider tokenProvider;
//
//    /**
//     * Authorize response entity.
//     *
//     * @param loginVM the login vm
//     * @return the response entity
//     */
//    @PostMapping(AUTHENTICATE_MAPPING)
//    public ResponseEntity<JwtToken> authorize(@Valid @RequestBody LoginVM loginVM) {
//        Authentication authentication = authenticationManager
//                .authenticate(new UsernamePasswordAuthenticationToken(loginVM.getPhone(), loginVM.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        boolean rememberMe = (loginVM.getRememberMe() == null) ? false : loginVM.getRememberMe();
//        String jwt = tokenProvider.createToken(authentication, rememberMe);
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add(AUTHORIZATION_HEADER, TOKEN_PREFIX + jwt);
//
//        log.info("Authenticated with token {}", jwt);
//
////        TwilioSms.sendMessage(loginVM.getPhone(), "Bạn vừa đăng nhập vào hệ thống HDHT Medical");
//
//        return new ResponseEntity<>(new JwtToken(jwt), httpHeaders, HttpStatus.OK);
//    }
//
//    /**
//     * Object to return as body in JWT Authentication.
//     */
//    @Data
//    @AllArgsConstructor
//    static class JwtToken {
//
//        @JsonProperty("id_token")
//        private String idToken;
//
//    }
//
//}