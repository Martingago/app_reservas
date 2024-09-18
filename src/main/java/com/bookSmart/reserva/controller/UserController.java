package com.bookSmart.reserva.controller;

import com.bookSmart.reserva.DTO.UserRequestDTO;
import com.bookSmart.reserva.DTO.UserResponseDTO;
import com.bookSmart.reserva.converter.UserConverter;
import com.bookSmart.reserva.model.UserModel;
import com.bookSmart.reserva.repository.UserRepository;
import com.bookSmart.reserva.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.bookSmart.reserva.utils.CustomResponseEntity;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserConverter userConverter;

    /**
     * Busca en la base de datos tanto por el id de un usuario como por su email
     * @param identificador
     * @return
     */
    @GetMapping("/public/profile/{id}")
    public CustomResponseEntity getUserById(@PathVariable("id") Long identificador){
        UserModel getUser = userService.findUserById(identificador);
        UserResponseDTO userResponseDTO = userConverter.toResponseDTO(getUser);
        return new CustomResponseEntity(userResponseDTO, "User was successfully founded", HttpStatus.OK);
    }


    /**
     * Genera un usuario en la Base de datos
     * @param userRequestDTO
     * @return
     */
    @PostMapping("register/user")
    public CustomResponseEntity createUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        UserModel newUser = userConverter.toModel(userRequestDTO); //Convierte el DTO en un objeto userModel
        newUser = userService.createUser(newUser); //Añade el userModel a la BBDD y recupera el nuevo objeto
        UserResponseDTO userResponseDTO = userConverter.toResponseDTO(newUser); // Convierte el nuevo objeto en DTO y lo envía el front-end
        return new CustomResponseEntity(userResponseDTO, "User successfully created",HttpStatus.CREATED); //Genera la respuesta
    }

    @DeleteMapping("/public/profile/{id}/delete")
    public CustomResponseEntity deleteUserById(@PathVariable("id") Long identificador){
        userService.deleteUserById(identificador);
        return new CustomResponseEntity(null, "User successfully deleted", HttpStatus.NO_CONTENT);
    }

}
