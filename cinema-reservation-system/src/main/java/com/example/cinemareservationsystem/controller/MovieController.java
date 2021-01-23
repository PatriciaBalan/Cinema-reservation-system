package com.example.cinemareservationsystem.controller;

import com.example.cinemareservationsystem.Service.implementation.MovieService;
import com.example.cinemareservationsystem.dto.MovieCreateDto;
import com.example.cinemareservationsystem.dto.MovieInfoDto;
import com.example.cinemareservationsystem.model.Movie;
import com.example.cinemareservationsystem.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/cinema/movie")
public class MovieController {

    private static final Logger LOG = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    public MovieController(MovieService movieService, MovieRepository movieRepository) {
        this.movieService = movieService;
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<MovieInfoDto> getAllMovie() {
        LOG.info("Fetch all the Movies...");
        return movieService.getAllMovie();
    }

    @PostMapping(path = "/create")
    ResponseEntity<MovieInfoDto> createMovie(@RequestBody MovieCreateDto mcd) {
        return ResponseEntity.ok(movieService.createMovie(mcd));
    }


    @GetMapping ("/{movieId}")
    public MovieInfoDto findById(@PathVariable ("movieId") int movieId) {
        return movieService.findById(movieId);
    }

    @PutMapping("/{movieId}")
        public ResponseEntity<MovieInfoDto> updateMovie(@PathVariable ("movieId") int movieId,
                                             @RequestBody Movie movie) {

        movieRepository.findById(movieId).get();
        movie.setMovieName(movie.getMovieName());
        movie.setMovieId(movie.getMovieId());
        movie.setMovieRoom(movie.getMovieRoom());
        movie.setSeatNumber(movie.getSeatNumber());
        movie.setPriceMovie(movie.getPriceMovie());
        movie.setMovieType(movie.getMovieType());
        movie.setDateMovie(movie.getDateMovie());
        movieRepository.save(movie);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int movieId) {
    movieService.deleteMovie(movieId);
    return ResponseEntity.ok().build();
    }
}
