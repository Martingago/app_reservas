package com.bookSmart.reserva.converter;

import com.bookSmart.reserva.DTO.RoleRequestDTO;
import com.bookSmart.reserva.DTO.RoleResponseDTO;
import com.bookSmart.reserva.model.RoleModel;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

    public RoleRequestDTO toRequestDto(RoleModel model){
        return RoleRequestDTO.builder().role(model.getRole()).build();
    }

    public RoleResponseDTO toResponseDto(RoleModel model){
        return RoleResponseDTO.builder().id(model.getId()).role(model.getRole()).build();
    }

    public RoleModel toModel(RoleRequestDTO dto){
        return RoleModel.builder().role(dto.getRole()).build();
    }
}
