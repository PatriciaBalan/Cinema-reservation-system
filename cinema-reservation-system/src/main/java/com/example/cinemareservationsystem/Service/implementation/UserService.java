package com.example.cinemareservationsystem.Service.implementation;

import com.example.cinemareservationsystem.Service.UserServiceInterface;
import com.example.cinemareservationsystem.components.UserMapper;
import com.example.cinemareservationsystem.dto.UserCreateDto;
import com.example.cinemareservationsystem.dto.UserInfoDto;
import com.example.cinemareservationsystem.model.Role;
import com.example.cinemareservationsystem.model.User;
import com.example.cinemareservationsystem.repository.RoleRepository;
import com.example.cinemareservationsystem.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
//import at.favre.lib.crypto.bcrypt.BCrypt;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInterface {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

     private RoleRepository roleRepository;
     private UserService userService;
     private UserRepository userRepository;
     private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserInfoDto createUser(UserCreateDto userCreateDto, String firstName) {
        return  userMapper.toDto(userRepository.save(userMapper.toEntity(userCreateDto, firstName)));
    }

    public String signUp(User user) {
        String status = "Existing User... Please Login !!!";
        List<User> list = userRepository.fetchUserByEmail(user.getEmail());
        List<Role> roleList = roleRepository.findAll();
        Role userRole=roleList.stream().filter(a->a.getNameRole().equals("user")).collect(Collectors.toList()).get(0);

        if (list.isEmpty()) {
            user.setPassword((user.getPassword()));
            user.setRole(userRole);
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
    public List<UserInfoDto> getAllUsers() {
        return userMapper.toDtoList(userRepository.findAll());
        //return userService.getAllUsers();
    }
}
