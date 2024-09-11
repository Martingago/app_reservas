package com.bookSmart.reserva.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleRequestDTO {

    @NotEmpty(message = "Role name is required")
    private String role;
}
