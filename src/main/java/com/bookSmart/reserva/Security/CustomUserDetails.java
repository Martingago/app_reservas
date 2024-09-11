package com.bookSmart.reserva.Security;

import com.bookSmart.reserva.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Set;

/**
 * Implementación de la clase UserDetails para obtener los detalles de un usuario authenticado:
 * username (mail) + password + roles
 */
@Builder
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final UserModel user;
    private final Set<? extends GrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }
}
