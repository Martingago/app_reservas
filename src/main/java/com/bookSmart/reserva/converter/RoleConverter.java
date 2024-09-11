package com.bookSmart.reserva.converter;

import com.bookSmart.reserva.DTO.RoleRequestDTO;
import com.bookSmart.reserva.DTO.RoleResponseDTO;
import com.bookSmart.reserva.model.RoleModel;

public class RoleConverter {

    public static RoleRequestDTO toRequestDto(RoleModel model){
        return RoleRequestDTO.builder().role(model.getRole()).build();
    }

    public static RoleResponseDTO toResponseDto(RoleModel model){
        return RoleResponseDTO.builder().id(model.getId()).role(model.getRole()).build();
    }

    public static RoleModel toModel(RoleRequestDTO dto){
        return RoleModel.builder().role(dto.getRole()).build();
    }
}
