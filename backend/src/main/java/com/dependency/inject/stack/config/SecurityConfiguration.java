package com.dependency.inject.stack.config;

import com.dependency.inject.stack.config.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import static com.dependency.inject.stack.common.AuthoritiesConstants.*;
import static com.dependency.inject.stack.common.ResourcesConstants.*;

/**
 * The type Security configuration.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DomainAccountDetailsService userDetailsService;

    /**
     * Jwt filter jwt filter.
     *
     * @return the jwt filter
     */
    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // Get AuthenticationManager bean
        return super.authenticationManagerBean();
    }

    /**
     * Password encoder password encoder.
     *
     * @return the password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configure global.
     *
     * @param auth the auth
     * @throws Exception the exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    	auth.userDetailsService(userDetailsService);
    }

    /**
     * Allow url encoded slash http firewall http firewall.
     *
     * @return the http firewall
     */
    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }

    /**
     * .cors() avoid request from another domain
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()
                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class)
//                .headers().frameOptions().disable()
//                .and()
                .authorizeRequests()
                .antMatchers("/api/authenticate").permitAll()
                .antMatchers("/api/post", "/api/post/**").hasAuthority(AUTHORITY_ADMIN)
                .antMatchers("/api/account/**").hasAuthority(AUTHORITY_USER)
//
//                .antMatchers(SWAGGER_UI_MAPPING, SWAGGER_UI_MAPPING.concat(RESOURCE_SUFFIX), SWAGGER_RESOURCES_MAPPING.concat(RESOURCE_SUFFIX), API_DOCS_MAPPING, API_DOCS_MAPPING.concat(RESOURCE_SUFFIX), WEBJARS_MAPPING.concat(RESOURCE_SUFFIX)).permitAll()
//                .antMatchers(SWAGGER_UI_MAPPING, SWAGGER_UI_MAPPING.concat(RESOURCE_SUFFIX), SWAGGER_RESOURCES_MAPPING.concat(RESOURCE_SUFFIX), API_DOCS_MAPPING, API_DOCS_MAPPING.concat(RESOURCE_SUFFIX), WEBJARS_MAPPING.concat(RESOURCE_SUFFIX)).permitAll()
//                .antMatchers(RESOURCE_API.concat(AUTHENTICATE_MAPPING)).permitAll()
//                .antMatchers(RESOURCE_API.concat(DEPARTMENT_MAPPING), RESOURCE_API.concat(DEPARTMENT_MAPPING).concat(RESOURCE_SUFFIX)).permitAll()
//                .antMatchers(RESOURCE_API.concat(APPOINTMENT_MAPPING)).hasAuthority(AUTHORITY_USER)
//                .antMatchers(RESOURCE_API.concat(APPOINTMENT_REQUEST_MAPPING)).hasAuthority(AUTHORITY_USER)
//                .antMatchers(RESOURCE_API.concat(APPOINTMENT_DEPARTMENT_MAPPING)).hasAnyAuthority(AUTHORITY_NURSE, AUTHORITY_ADMIN)
//                .antMatchers(RESOURCE_API.concat(APPOINTMENT_MAPPING).concat("/tasks")).hasAnyAuthority(AUTHORITY_DOCTOR, AUTHORITY_PATIENT)
//                .antMatchers(RESOURCE_API.concat(APPOINTMENT_MAPPING).concat("/success")).hasAuthority(AUTHORITY_USER)
//                .antMatchers(RESOURCE_API.concat(APPOINTMENT_MAPPING).concat("/finished")).hasAuthority(AUTHORITY_USER)
//                .antMatchers(RESOURCE_API.concat(APPOINTMENT_MAPPING).concat("/cancel")).hasAuthority(AUTHORITY_USER)
//                .antMatchers(RESOURCE_API.concat(APPOINTMENT_MAPPING), RESOURCE_API.concat(APPOINTMENT_MAPPING).concat(RESOURCE_SUFFIX)).hasAuthority(AUTHORITY_USER)
//                .antMatchers(RESOURCE_API.concat(ACCOUNT_MAPPING), RESOURCE_API.concat(ACCOUNT_MAPPING).concat(RESOURCE_SUFFIX)).permitAll()
//                .antMatchers(RESOURCE_API.concat(DOCTOR_MAPPING)).hasAuthority(AUTHORITY_ADMIN)
//                .antMatchers(RESOURCE_API.concat(MEDICAL_HISTORY_MAPPING), RESOURCE_API.concat(MEDICAL_HISTORY_MAPPING).concat(RESOURCE_SUFFIX)).hasAuthority(AUTHORITY_USER)
//                .antMatchers(RESOURCE_API.concat(NURSE_MAPPING)).hasAuthority(AUTHORITY_ADMIN)
//                .antMatchers(RESOURCE_API.concat(PATIENT_MAPPING), RESOURCE_API.concat(PATIENT_MAPPING).concat(RESOURCE_SUFFIX)).hasAuthority(AUTHORITY_USER)
//                .antMatchers(RESOURCE_API.concat(USER_MAPPING)).hasAuthority(AUTHORITY_ADMIN)
//                .antMatchers(RESOURCE_API.concat(RESOURCE_SUFFIX)).hasAuthority(AUTHORITY_USER)
//                .antMatchers(RESOURCE_API.concat("/upload-avatar")).hasAuthority(AUTHORITY_USER)
//                .antMatchers("/uploads/**").permitAll()
//                .antMatchers("/uploads/", "/uploads").permitAll()
//                .antMatchers(RESOURCE_SUFFIX).authenticated()
                .anyRequest().authenticated();
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
//                http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
        
    }

    /**
     * Configure web security for resources static
     *
     * @param web WebSecurity
     */
    @Override
    public void configure(WebSecurity web) {
        web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
        web.ignoring().antMatchers("/css" + RESOURCE_SUFFIX,
                "/js" + RESOURCE_SUFFIX,
                "/images" + RESOURCE_SUFFIX,
                WEBJARS_MAPPING + RESOURCE_SUFFIX,
                "/fonts" + RESOURCE_SUFFIX)
                .antMatchers(HttpMethod.OPTIONS, RESOURCE_SUFFIX)
                .antMatchers("/uploads/**", "/uploads/", "/uploads")
                .antMatchers("/swagger-ui/index.html")
                .antMatchers("/test" + RESOURCE_SUFFIX);
    }
}