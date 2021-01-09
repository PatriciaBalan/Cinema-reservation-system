package com.example.cinemareservationsystem.components;

import com.example.cinemareservationsystem.dto.MovieCreateDto;
import com.example.cinemareservationsystem.dto.MovieInfoDto;
import com.example.cinemareservationsystem.dto.UserCreateDto;
import com.example.cinemareservationsystem.dto.UserInfoDto;
import com.example.cinemareservationsystem.model.Movie;
import com.example.cinemareservationsystem.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

        public static User toEntity(UserCreateDto userCreateDto, String firstName) {
            User user = new User();
            user.setFirstName(userCreateDto.getFirstName());
            user.setLastName(userCreateDto.getLastName());
            user.setRole(userCreateDto.getRole());
            user.setEmail(userCreateDto.getEmail());
            user.setPassword(userCreateDto.getPassword());
            return user;
        }

        public static UserInfoDto toDto(User user) {
            UserInfoDto userInfoDto = new UserInfoDto();
            userInfoDto.setFirstName(user.getFirstName());
            userInfoDto.setLastName(user.getLastName());
            userInfoDto.setEmail(user.getEmail());
            userInfoDto.setPassword(user.getPassword());
            userInfoDto.setUserId(user.getUserId());

            return userInfoDto;
        }

        public static List<UserInfoDto> toDtoList(Iterable<User> entities){
            List<UserInfoDto> results = new ArrayList<>();
            entities.forEach(entity -> results.add(toDto(entity)));

            return results;
        }
}
