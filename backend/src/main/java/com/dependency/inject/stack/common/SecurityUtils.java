package com.dependency.inject.stack.common;

import static com.dependency.inject.stack.common.AuthoritiesConstants.AUTHORITY_ADMIN;
import static com.dependency.inject.stack.common.AuthoritiesConstants.AUTHORITY_ANONYMOUS;

import java.util.Optional;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * The type Security utils.
 *
 * @author Huu Duan
 */
public final class SecurityUtils {

    /**
     * Get the login of the current user.
     *
     * @return the phone of the current user
     */
    public static Optional<String> getCurrentUserLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map(authentication -> {
                    if (authentication.getPrincipal() instanceof UserDetails) {
                        UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
                        return springSecurityUser.getUsername();
                    } else if (authentication.getPrincipal() instanceof String) {
                        return (String) authentication.getPrincipal();
                    }
                    return null;
                });
    }

    /**
     * Check if a user is authenticated.
     *
     * @return true if the user is authenticated, false otherwise
     */
    public static boolean isAuthenticated() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map(authentication -> authentication.getAuthorities().stream()
                        .noneMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(AUTHORITY_ANONYMOUS)))
                .orElse(false);
    }

    /**
     * Check if a user is ADMIN.
     *
     * @return true if the user is ADMIN, false otherwise
     */
    public static boolean isAdmin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map(authentication -> authentication.getAuthorities().stream()
                        .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(AUTHORITY_ADMIN)))
                .orElse(false);
    }
}
