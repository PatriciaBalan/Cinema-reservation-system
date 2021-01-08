package com.example.cinemareservationsystem.repository;

import com.example.cinemareservationsystem.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Movie, Integer> {

}
