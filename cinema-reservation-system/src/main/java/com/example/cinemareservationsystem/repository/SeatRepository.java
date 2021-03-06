package com.example.cinemareservationsystem.repository;

import com.example.cinemareservationsystem.model.Movie;
import com.example.cinemareservationsystem.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

}
