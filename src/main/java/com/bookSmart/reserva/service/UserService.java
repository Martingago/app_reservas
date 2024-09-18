package com.bookSmart.reserva.service;

import com.bookSmart.reserva.model.UserModel;
import com.bookSmart.reserva.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Busca un usuario en la base de datos a través de un id introducido como parámetro
     * @param id Long con el identificador del usuario a buscar
     * @return UserModel con los datos del usuario encontrado o un EntityNotFoundException en caso de que el usuario no exista
     */
    public UserModel findUserById(Long id){
        Optional<UserModel> getUser = userRepository.findById(id);
        return getUser.orElseThrow(() -> new EntityNotFoundException("User with id: " + id + " was not founded"));
    }

    /**
     * Crea un usuario en la base de datos
     * @param userModel modelo de usuario con la información a añadir en la base de datos
     * @return UserModel con los datos que han sido añadidos en la base de datos
     */
    public UserModel createUser(UserModel userModel){
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword())); //Encripta la contraseña
        try{
            return userRepository.save(userModel);
        }catch (DataIntegrityViolationException ex){
            throw new DataIntegrityViolationException("Error during creating user: " + ex);
        }
    }

    /**
     * Comprueba y elimina un usuario de la BBDD en base a su id
     * @param id Long del usuario a verificar y eliminar de la base de datos
     */
    public void deleteUserById(Long id){
        findUserById(id); //Busca y comprueba que el usuario que se quiere eliminar exista en la BBDD
        userRepository.deleteById(id); //Si el usuario existe se elimina
    }

}
