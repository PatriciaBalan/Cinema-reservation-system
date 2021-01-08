package com.example.cinemareservationsystem.dto;

import java.util.Date;

public class MovieCreateDto {

    private String movieName;

    private String movieType;

    private int movieRoom;

    private int seatNumber;

    private Date dateMovie;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public int getMovieRoom() {
        return movieRoom;
    }

    public void setMovieRoom(int movieRoom) {
        this.movieRoom = movieRoom;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Date getDateMovie() {
        return dateMovie;
    }

    public void setDateMovie(Date dateMovie) {
        this.dateMovie = dateMovie;
    }
}
