package com.example.cinemareservationsystem.Service;

import com.example.cinemareservationsystem.dto.MovieCreateDto;
import com.example.cinemareservationsystem.dto.MovieInfoDto;
import com.example.cinemareservationsystem.model.Movie;

import java.util.List;

public interface MovieServiceInterface {

    MovieInfoDto createMovie(MovieCreateDto movie);

    List<MovieInfoDto> getAllMovie(Integer pageNo,Integer pageSize, String sortBy);

    List<MovieInfoDto> getAllMovie();

    MovieInfoDto findById(int movieId);

//    void updateMovie (Movie movie);

    void deleteMovie (int movieId);

    void updateMovie (int movieId,
                     String movieName,
                     String movieType,
                     int movieRoom,
                     int seatNumber,
                     String dateMovie,
                      String priceMovie);
}
