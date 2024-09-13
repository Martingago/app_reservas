package com.bookSmart.reserva.converter;

import com.bookSmart.reserva.DTO.UserRequestDTO;
import com.bookSmart.reserva.DTO.UserResponseDTO;
import com.bookSmart.reserva.model.RoleModel;
import com.bookSmart.reserva.model.UserModel;
import com.bookSmart.reserva.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    @Autowired
    RoleRepository roleRepository;

    /**
     * Convierte un DTO en un userModel para trabajar con él en la Base de datos.
     * @param dto
     * @return
     */
    public UserModel toModel(UserRequestDTO dto){
        Set<RoleModel> roles = new HashSet<>(roleRepository.findAllById(dto.getRoles()));
        return UserModel.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .password(dto.getPassword())
                .roleSet(roles) //Se convierten los roles ID en roleModel
                .build();
    }

    /**
     * Maneja la salida de datos de un usuario que se le quiere enviar al front-end
     * @param userModel
     * @return
     */
    public UserResponseDTO toResponseDTO(UserModel userModel){
        Set<Long> rolesId = userModel.getRoleSet().stream()
                .map(RoleModel::getId).collect(Collectors.toSet());

        return UserResponseDTO.builder()
                .id(userModel.getId())
                .email(userModel.getEmail())
                .name(userModel.getName())
                .roles_id(rolesId) //Envía los roles como un id
                .build();
    }
}
