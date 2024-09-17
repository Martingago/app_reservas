package com.bookSmart.reserva.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class APIResponseDTO {
    private final int status;
    private final String message;
    private final Object data;
}
