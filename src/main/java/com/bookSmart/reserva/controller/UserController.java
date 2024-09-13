package com.bookSmart.reserva.controller;

import com.bookSmart.reserva.DTO.UserRequestDTO;
import com.bookSmart.reserva.DTO.UserResponseDTO;
import com.bookSmart.reserva.converter.UserConverter;
import com.bookSmart.reserva.model.UserModel;
import com.bookSmart.reserva.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserConverter userConverter;

    @PostMapping("/user")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        UserModel newUser = userConverter.toModel(userRequestDTO); //Convierte el DTO en un objeto userModel
        newUser = userService.createUser(newUser); //Añade el userModel a la BBDD y recupera el nuevo objeto
        UserResponseDTO userResponseDTO = userConverter.toResponseDTO(newUser); // Convierte el nuevo objeto en DTO y lo envía el front-end

        return new ResponseEntity(userResponseDTO, HttpStatus.CREATED); //Genera la respuesta
    }

}
