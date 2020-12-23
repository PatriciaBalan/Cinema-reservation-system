package com.example.cinemareservationsystem.Service.implementation;

import com.example.cinemareservationsystem.Service.MovieServiceInterface;
import com.example.cinemareservationsystem.components.MovieMapper;
import com.example.cinemareservationsystem.dto.MovieCreateDto;
import com.example.cinemareservationsystem.dto.MovieInfoDto;
import com.example.cinemareservationsystem.exception.MovieNotFoundException;
import com.example.cinemareservationsystem.model.Movie;
import com.example.cinemareservationsystem.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements MovieServiceInterface {

     private static final Logger LOG = LoggerFactory.getLogger(MovieService.class);

    private final MovieMapper movieMapper;
    private MovieRepository movieRepository;

    public MovieService(MovieMapper movieMapper, MovieRepository movieRepository) {
        this.movieMapper = movieMapper;
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieInfoDto createMovie (MovieCreateDto movieCreateDto, String movieName) {
        return movieMapper.toDto(movieRepository.save(movieMapper.toEntity(movieCreateDto, movieName)));
    }

    @Override
    public List<MovieInfoDto> getAllMovie (Integer pageNo,
                                          Integer pageSize,
                                          String sortBy) {

        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        Page<Movie> pageResult = movieRepository.findAll(pageable);

        return movieMapper.toDtoList(pageResult.getContent());
    }

    @Override
    public List<MovieInfoDto> getAllMovie() {
        return movieMapper.toDtoList(movieRepository.findAll());
    }

    @Override
    public void deleteMovie(int movieId) {
        movieRepository.deleteById(getAllMovie().indexOf(movieId));
    }


    @Override
    public void updateMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public MovieInfoDto findById(Integer id) {
        Optional<Movie>  movie = movieRepository.findById(id);
        if (!movie.isPresent()) {
            throw new MovieNotFoundException("Movie with ID = " + id + " could not be found.");
        } else {
            return movieMapper.toDto(movie.get());
        }
    }

}
