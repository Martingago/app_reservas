package com.bookSmart.reserva.controller;

import com.bookSmart.reserva.DTO.RoleRequestDTO;
import com.bookSmart.reserva.DTO.RoleResponseDTO;
import com.bookSmart.reserva.converter.RoleConverter;
import com.bookSmart.reserva.model.RoleModel;
import com.bookSmart.reserva.service.RoleService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.bookSmart.reserva.utils.CustomResponseEntity;

import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    RoleConverter roleConverter;

    /**
     * Lista todos los objetos existentes en la tabla de roles de la BBDD
     * @return ResponseEntity con la lista de objetos + codigo de estado
     */
    @GetMapping("/list")
    public CustomResponseEntity listRoles() {
        //Busca todos los roles en la Base de datos y los devuelve en forma de Set
        Set<RoleResponseDTO> listRoleResponseDTO = roleService.getRoles()
                .stream().map(role -> roleConverter.toResponseDto(role)).collect(Collectors.toSet());

        return new CustomResponseEntity(listRoleResponseDTO, HttpStatus.OK); //Devuelve un ResponseEntity
    }

    /**
     * Crea un objeto Role en la base de datos
     * @param roleRequest DTO roles que el software admite desde el cliente
     * @return ResponseEntity con el objeto creado + codigo de estado
     */
    @PostMapping("/create")
    public CustomResponseEntity createRole(@Valid @RequestBody RoleRequestDTO roleRequest){
        RoleModel newRoll = roleConverter.toModel(roleRequest); //Se convierte el DtoRequest en un dto para añadir en la BBDD
        newRoll = roleService.addRol(newRoll);
        RoleResponseDTO responseDTO = roleConverter.toResponseDto(newRoll);
        return new CustomResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    /**
     * Elimina un rol de la base de datos
     * @param id del rol a eliminar
     * @return null + código de estado de la operación
     */
    @DeleteMapping("/delete/{id}")
    public CustomResponseEntity deleteRole(@PathVariable("id") Long id){
            roleService.deleteRoleById(id);
            String messageResponse = "Rol with id: " + id + " was successfully removed.";
            return new CustomResponseEntity(null, messageResponse,HttpStatus.NO_CONTENT); // 204 el rol ha sido eliminado con éxito
            // -> 204 no envía cuerpo con el mensaje. Eliminar un rol con éxito no devolverá ningún ResponseEntity. Cambiar por HttpStatus.OK para devolver un ResponseEntity
        }

}
