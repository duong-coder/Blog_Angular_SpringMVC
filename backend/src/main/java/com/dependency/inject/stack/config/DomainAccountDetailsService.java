package com.dependency.inject.stack.config;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dependency.inject.stack.domain.Account;
import com.dependency.inject.stack.domain.User;
import com.dependency.inject.stack.repository.AccountRepository;

/**
 * The type Domain user details service.
 */
@Service
public class DomainAccountDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        Account account = accountRepository.findByPhone(phone);
        if (account == null) {
            throw new UsernameNotFoundException("User not found");
        }

//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        List<Authority> authorities = user.getAuthorities();
//        authorities.forEach(authority -> grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName())));
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getPhone(), user.getPassword(), grantedAuthorities);
        
        return null;
    }
}