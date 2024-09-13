package com.bookSmart.reserva.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // Incluir solo campos no nulos
public class UserResponseDTO {
    private long id;
    private String email;
    private String name;
    private Set<String> roles_string; //Roles en formato String
    private Set<Long> roles_id; //Roles formato Long id
}
