package com.example.cinemareservationsystem.Service;

import com.example.cinemareservationsystem.dto.UserCreateDto;
import com.example.cinemareservationsystem.dto.UserInfoDto;

import java.util.List;

public interface UserServiceInterface {

    UserInfoDto createUser (UserCreateDto userCreateDto, String firstName);

    List<UserInfoDto> getAllUsers();
}
