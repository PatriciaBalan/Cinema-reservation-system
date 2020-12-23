package com.example.cinemareservationsystem.Service;

import com.example.cinemareservationsystem.dto.MovieCreateDto;
import com.example.cinemareservationsystem.dto.MovieInfoDto;
import com.example.cinemareservationsystem.model.Movie;

import java.util.List;

public interface MovieServiceInterface {

    MovieInfoDto createMovie(MovieCreateDto movie, String movieName);

    List<MovieInfoDto> getAllMovie(Integer pageNo,Integer pageSize, String sortBy);

    List<MovieInfoDto> getAllMovie();

    void deleteMovie (int movieId);

    void updateMovie(Movie movie);

    MovieInfoDto findById(Integer id);

}
