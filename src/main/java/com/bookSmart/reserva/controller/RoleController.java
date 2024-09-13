package com.bookSmart.reserva.controller;

import com.bookSmart.reserva.DTO.RoleRequestDTO;
import com.bookSmart.reserva.DTO.RoleResponseDTO;
import com.bookSmart.reserva.converter.RoleConverter;
import com.bookSmart.reserva.model.RoleModel;
import com.bookSmart.reserva.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<RoleResponseDTO> createRole(@Valid @RequestBody RoleRequestDTO roleRequest){
        System.out.println("Creating ROLE");
        RoleModel newRoll = RoleConverter.toModel(roleRequest); //Se convierte el DtoRequest en un dto para añadir en la BBDD
        newRoll = roleService.addRol(newRoll);
        RoleResponseDTO responseDTO = RoleConverter.toResponseDto(newRoll);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
