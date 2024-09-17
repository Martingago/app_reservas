package com.bookSmart.reserva.controller;

import com.bookSmart.reserva.DTO.APIResponseDTO;
import com.bookSmart.reserva.DTO.RoleRequestDTO;
import com.bookSmart.reserva.DTO.RoleResponseDTO;
import com.bookSmart.reserva.converter.RoleConverter;
import com.bookSmart.reserva.model.RoleModel;
import com.bookSmart.reserva.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    RoleConverter roleConverter;

    @PostMapping("/create")
    public ResponseEntity<APIResponseDTO> createRole(@Valid @RequestBody RoleRequestDTO roleRequest){
        RoleModel newRoll = roleConverter.toModel(roleRequest); //Se convierte el DtoRequest en un dto para añadir en la BBDD
        newRoll = roleService.addRol(newRoll);
        RoleResponseDTO responseDTO = roleConverter.toResponseDto(newRoll);
        return new ResponseEntity<>(new APIResponseDTO(true, "Role successfully created", responseDTO), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<APIResponseDTO> listRoles() {
        //Busca todos los roles en la Base de datos y los devuelve en forma de Set
        Set<RoleResponseDTO> listRoleResponseDTO = roleService.getRoles()
                .stream().map(role -> roleConverter.toResponseDto(role)).collect(Collectors.toSet());
        //Devuelve un ResponseEntity
        return new ResponseEntity<>(new APIResponseDTO(true, "List of Roles successfully founded", listRoleResponseDTO), HttpStatus.FOUND);
    }
}
