package com.example.cinemareservationsystem.controller;


import com.example.cinemareservationsystem.Service.implementation.UserService;
import com.example.cinemareservationsystem.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/cinema")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@RequestBody User login, HttpServletResponse response) {
        String nulls = null;

        return "success";
    }

    @RequestMapping(method = RequestMethod.POST)
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
}
