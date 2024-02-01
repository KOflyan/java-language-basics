package com.pokemon.pokemonapi.security;

import com.pokemon.pokemonapi.trainer.Trainer;
import com.pokemon.pokemonapi.trainer.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final TrainerRepository trainerRepository;

    @Autowired
    public UserDetailsServiceImpl(
        TrainerRepository trainerRepository
    ) {
        super();
        this.trainerRepository = trainerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Trainer trainer = this.trainerRepository
                .findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));


        GrantedAuthority authority = new SimpleGrantedAuthority(trainer.getRole().name());

        return new User(trainer.getUsername(), trainer.getPassword(), Collections.singletonList(authority));
    }
}