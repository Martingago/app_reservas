package com.bookSmart.reserva.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleResponseDTO {
    private long id;
    private String role;
}
