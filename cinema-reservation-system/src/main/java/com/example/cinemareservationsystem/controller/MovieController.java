package com.example.cinemareservationsystem.controller;

import com.example.cinemareservationsystem.Service.implementation.MovieService;
import com.example.cinemareservationsystem.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/movie")
public class MovieController {

    private static final Logger LOG = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;


    @RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
    public Optional<Movie> getMovieInfo(@PathVariable("movieId") Integer movieId) {
        return movieService.getMovieInfo(movieId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Movie> getAllMovies() {
        LOG.info("Fetch all the Movies...");
        return movieService.getAllMovies();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Movie> addMovie(@RequestBody Movie movie) {
        LOG.info("Add a Movie...");
        movieService.addMovie(movie);
        return movieService.getAllMovies();
    }
}
