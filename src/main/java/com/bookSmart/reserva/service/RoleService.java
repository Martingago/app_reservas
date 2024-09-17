package com.bookSmart.reserva.service;


import com.bookSmart.reserva.model.RoleModel;
import com.bookSmart.reserva.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    return roleRepository.save(roleModel);
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
        if(optRoleModel.isPresent()){
            return optRoleModel.get();
        }
        throw  new EntityNotFoundException("Role with id:" + id + " was not founded");
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
