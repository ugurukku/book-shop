package com.ugurukku.kitabal.security;

import com.ugurukku.kitabal.repositories.UserRepository;
import com.ugurukku.kitabal.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MyUserDetails(
                repository
                        .findUserByEmail(username)
                        .orElseThrow(() ->  new UsernameNotFoundException("Istifadəçi adı və yta şifrə yanlışdır"))
        );
    }
}
