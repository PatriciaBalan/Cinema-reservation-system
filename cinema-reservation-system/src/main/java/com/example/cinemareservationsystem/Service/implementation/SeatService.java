package com.example.cinemareservationsystem.Service.implementation;

import com.example.cinemareservationsystem.Service.SeatServiceInterface;
import com.example.cinemareservationsystem.components.MovieMapper;
import com.example.cinemareservationsystem.model.Seat;
import com.example.cinemareservationsystem.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService implements SeatServiceInterface {

    private SeatRepository seatRepository;
    private final MovieMapper movieMapper;

    @Autowired
    public SeatService(SeatRepository seatRepository, MovieMapper movieMapper) {
        this.seatRepository = seatRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

}
