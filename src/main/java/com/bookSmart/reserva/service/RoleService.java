package com.bookSmart.reserva.service;


import com.bookSmart.reserva.model.RoleModel;
import com.bookSmart.reserva.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

@Autowired
    RoleRepository roleRepository;



    /**
     * Añade un rol a la base de datos
     * @param roleModel
     * @return
     */
    public RoleModel addRol(RoleModel roleModel){
        try{
            return roleRepository.save(roleModel);
        }catch (DataIntegrityViolationException ex){
            throw new DataIntegrityViolationException("Error during creating role, Duplicate key entry: " + ex.getMessage());
        }
}

    public List<RoleModel> getRoles(){
        return roleRepository.findAll();
    }

    /**
     * Busca un rol en la base de datos por su ID
     * @param id del rol a buscar
     * @return RoleModel o error EntityNotFound si no existe
     */
    public RoleModel getRoleById(Long id){
        Optional<RoleModel> optRoleModel = roleRepository.findById(id);
       return optRoleModel.orElseThrow(() -> new EntityNotFoundException("Role with id: " + id + " was not founded"));
    }

    /**
     * Verifica y elimina un rol de la base de datos
     * @param id del rol a eliminar
     */
    public void deleteRoleById(Long id){
            getRoleById(id);
            roleRepository.deleteById(id);
        }

}
