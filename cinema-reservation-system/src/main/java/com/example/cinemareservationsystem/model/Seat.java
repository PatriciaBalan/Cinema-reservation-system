package com.example.cinemareservationsystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Seat {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)

 @Column(name = "seatNumber")
 private Integer seatNumber;

 @ManyToOne
 @JoinColumn(name = "movieRoom")
 @JsonManagedReference
 private Movie movie;
}
