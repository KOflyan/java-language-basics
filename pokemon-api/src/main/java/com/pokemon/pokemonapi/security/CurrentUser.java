package com.pokemon.pokemonapi.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CurrentUser {
    public User get() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() != null
                && UserDetails.class.isAssignableFrom(authentication.getPrincipal().getClass())
        ) {
            return (User) authentication.getPrincipal();
        }
        throw new BadCredentialsException("Invalid authentication!");
    }
}
