package com.example.cinemareservationsystem.Service.implementation;

import com.example.cinemareservationsystem.Service.UserServiceInterface;
import com.example.cinemareservationsystem.model.User;
import com.example.cinemareservationsystem.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import at.favre.lib.crypto.bcrypt.BCrypt;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public String signUp(User user) {
        String status = "Existing User... Please Login !!!";
        List<User> list = userRepository.fetchUserByEmail(user.getEmail());

        if (list.isEmpty()) {
            user.setPassword((user.getPassword()));
//            user.setRole(Enum<Role>);
            userRepository.save(user);
            status = "Success";
        } else
            LOG.info(status);

        return status;
    }

//    private String hashPassword(String password) {
//        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
//    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
