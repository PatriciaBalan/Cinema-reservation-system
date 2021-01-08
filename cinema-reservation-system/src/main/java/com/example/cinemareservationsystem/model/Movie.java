package com.example.cinemareservationsystem.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name ="Movie")
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int movieId;

    @Column
    private String movieName;

    @Column
    private String movieType;

    @Column
    private int movieRoom;

    @Column
    private int seatNumber;

    @Column
    private Date dateMovie;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Movie() {
    }

    public Movie(int movieId, String movieName, String movieType, int movieRoom, Date dateMovie, int seatNumber) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieType = movieType;
        this.movieRoom = movieRoom;
        this.dateMovie = dateMovie;
        this.seatNumber = seatNumber;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movie_id) {
        this.movieId = movie_id;
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieType='" + movieType + '\'' +
                ", movieRoom=" + movieRoom +
                ", seatNumber=" + seatNumber +
                ", dateMovie=" + dateMovie +
                ", createdAt=" + createdAt +
                '}';
    }
}




