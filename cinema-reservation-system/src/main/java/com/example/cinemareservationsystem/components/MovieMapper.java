package com.example.cinemareservationsystem.components;

import com.example.cinemareservationsystem.dto.MovieCreateDto;
import com.example.cinemareservationsystem.dto.MovieInfoDto;
import com.example.cinemareservationsystem.model.Movie;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {
    public static Movie toEntity(MovieCreateDto movieCreateDto) {
        Movie movie = new Movie();
        movie.setMovieName(movieCreateDto.getMovieName());
        movie.setMovieType(movieCreateDto.getMovieType());
        movie.setMovieRoom(movieCreateDto.getMovieRoom());
        movie.setSeatNumber(movieCreateDto.getSeatNumber());
        movie.setDateMovie(movieCreateDto.getDateMovie());
        movie.setPriceMovie(movieCreateDto.getPriceMovie());
        movie.setCreatedAt(LocalDateTime.now());
        return movie;
    }

    public static MovieInfoDto toDto(Movie movie) {
        MovieInfoDto movieInfoDto = new MovieInfoDto();
        movieInfoDto.setMovieId(movie.getMovieId());
        movieInfoDto.setMovieName(movie.getMovieName());
        movieInfoDto.setMovieRoom(movie.getMovieRoom());
        movieInfoDto.setMovieType(movie.getMovieType());
        movieInfoDto.setSeatNumber(movie.getSeatNumber());
        movieInfoDto.setDateMovie(movie.getDateMovie());
        movieInfoDto.setPriceMovie(movie.getPriceMovie());
        return movieInfoDto;
    }

    public static List<MovieInfoDto> toDtoList(Iterable<Movie> entities){
        List<MovieInfoDto> results = new ArrayList<>();
        entities.forEach(entity -> results.add(toDto(entity)));

        return results;
    }
}
