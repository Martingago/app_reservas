package com.bookSmart.reserva.service;

import com.bookSmart.reserva.DTO.RoleRequestDTO;
import com.bookSmart.reserva.model.RoleModel;
import com.bookSmart.reserva.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
