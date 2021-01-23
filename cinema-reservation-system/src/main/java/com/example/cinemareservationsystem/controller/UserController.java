package com.example.cinemareservationsystem.controller;


import com.example.cinemareservationsystem.Service.implementation.UserService;
import com.example.cinemareservationsystem.dto.MovieCreateDto;
import com.example.cinemareservationsystem.dto.MovieInfoDto;
import com.example.cinemareservationsystem.dto.UserCreateDto;
import com.example.cinemareservationsystem.dto.UserInfoDto;
import com.example.cinemareservationsystem.model.Movie;
import com.example.cinemareservationsystem.model.User;
import com.example.cinemareservationsystem.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/cinema")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@RequestBody User login, HttpServletResponse response) {
        String nulls = null;

        return "{}";
    }

    @PostMapping(path="/users/signup")
    public void signUp(@RequestBody User user, HttpServletResponse response) {
        log.info("Sign Up....");

        try {
            String status = userService.signUp(user);

            if (!"Success".equalsIgnoreCase(status))
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, status);
            else
                response.sendError(HttpServletResponse.SC_OK, status);
        } catch (Exception e) {
            log.error("Exception : " + e);
        }
    }


    @PostMapping(path = "/users/create")
    public @ResponseBody String createUser(@RequestBody UserCreateDto ucd) {
        User user = new User ();
        user.setFirstName(ucd.getFirstName());
        user.setLastName(ucd.getLastName());
        user.setEmail(ucd.getEmail());
        user.setPassword(ucd.getPassword());
        user.setRole(ucd.getRole());
        userRepository.save(user);
        return "Saved";
    }


    @GetMapping("/users")
    public List<UserInfoDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
