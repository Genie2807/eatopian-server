package com.eatopian.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.eatopian.dao.AccountDao;


@Component
public class AccountAuthenticationProvider implements AuthenticationProvider {
    private final AccountDao accountDao;

    @Autowired
    public AccountAuthenticationProvider(AccountDao accountDao) {
        if (accountDao == null) {
            throw new IllegalArgumentException("accountDao cannot be null");
        }
        this.accountDao = accountDao;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        
//        String userName = token.getName();
//        String domain = token.getDomain();
//        String email = userName + "@" + domain;
//        CalendarUser user = email == null ? null : calendarService.findUserByEmail(email);
//        if(user == null) {
//            throw new UsernameNotFoundException("Invalid username/password");
//        }
//        String password = user.getPassword();
//        if(!password.equals(token.getCredentials())) {
//            throw new BadCredentialsException("Invalid username/password");
//        }
//        Collection<? extends GrantedAuthority> authorities = CalendarUserAuthorityUtils.createAuthorities(user);
//        return new DomainUsernamePasswordAuthenticationToken(user, password, domain, authorities);
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
