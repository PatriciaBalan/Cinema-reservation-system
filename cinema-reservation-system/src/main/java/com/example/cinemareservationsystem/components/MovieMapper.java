package com.example.cinemareservationsystem.components;

import com.example.cinemareservationsystem.dto.MovieCreateDto;
import com.example.cinemareservationsystem.dto.MovieInfoDto;
import com.example.cinemareservationsystem.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {
    public static Movie toEntity(MovieCreateDto movieCreateDto, String movieName) {
        Movie movie = new Movie();
        movie.setMovieName(movieCreateDto.getMovieName());
        movie.setMovieType(movieCreateDto.getMovieType());
        movie.setMovieRoom(movieCreateDto.getMovieRoom());
        return movie;
    }

    public static MovieInfoDto toDto(Movie movie) {
        MovieInfoDto movieInfoDto = new MovieInfoDto();
        movieInfoDto.setMovieName(movie.getMovieName());
        movieInfoDto.setMovieRoom(movie.getMovieRoom());
        movieInfoDto.setMovieType(movie.getMovieType());

        return movieInfoDto;
    }

    public static List<MovieInfoDto> toDtoList(Iterable<Movie> entities){
        List<MovieInfoDto> results = new ArrayList<>();
        entities.forEach(entity -> results.add(toDto(entity)));

        return results;
    }
}
