package com.example.cinemareservationsystem.repository;

import com.example.cinemareservationsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("Select user from User user where user.email = :email")
    List<User> fetchUserByEmail(@Param("email") String email);
}
