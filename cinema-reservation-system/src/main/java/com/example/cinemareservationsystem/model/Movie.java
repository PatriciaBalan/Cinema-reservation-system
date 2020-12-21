package com.example.cinemareservationsystem.model;

import javax.persistence.*;

@Entity(name ="Movie")
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int movie_id;

    @Column
    private String movieName;

    @Column
    private String movieType;

    @Column
    private int movieRoom;

    public Movie() {
    }

    public Movie(int movie_id, String movieName, String movieType, int movieRoom) {
        this.movie_id = movie_id;
        this.movieName = movieName;
        this.movieType = movieType;
        this.movieRoom = movieRoom;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
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

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", movieName='" + movieName + '\'' +
                ", movieType='" + movieType + '\'' +
                ", movieRoom=" + movieRoom +
                '}';
    }
}
