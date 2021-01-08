package com.example.cinemareservationsystem.controller;

import com.example.cinemareservationsystem.Service.implementation.SeatService;
import com.example.cinemareservationsystem.model.Seat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cinema")
public class SeatController {

    private static final Logger log = LoggerFactory.getLogger(SeatController.class);

    @Autowired
    private SeatService seatService;


    @GetMapping("/seats")
    public List<Seat> getAllSeats() {
      return seatService.getAllSeats();
    }
}
