package com.bookSmart.reserva.DTO;

import lombok.Data;

import java.util.Set;

@Data
public class UserResponseDTO {

    private String email;
    private String name;
    private Set<String> roles;
}
