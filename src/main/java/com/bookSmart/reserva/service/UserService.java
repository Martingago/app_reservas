package com.bookSmart.reserva.service;

import com.bookSmart.reserva.model.UserModel;
import com.bookSmart.reserva.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Crea un usuario en la base de datos
     * @param userModel
     * @return
     */
    public UserModel createUser(UserModel userModel){
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword())); //Encripta la contraseña
        return userRepository.save(userModel);
    }

}
