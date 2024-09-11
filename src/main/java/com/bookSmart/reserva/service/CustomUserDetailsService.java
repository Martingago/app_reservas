package com.bookSmart.reserva.service;

import com.bookSmart.reserva.Security.CustomUserDetails;
import com.bookSmart.reserva.model.UserModel;
import com.bookSmart.reserva.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("Error, user with email: " + email + " was not founded"));
        Set<SimpleGrantedAuthority> authoritySet = userModel.getRoleSet()
                .stream().map(role -> new SimpleGrantedAuthority("ROLE_"+ role.getRole()))
                .collect(Collectors.toSet());
        return new CustomUserDetails(userModel , authoritySet);
    }
}
