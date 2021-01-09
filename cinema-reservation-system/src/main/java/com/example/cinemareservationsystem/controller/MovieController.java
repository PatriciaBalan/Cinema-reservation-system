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

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/cinema")
public class MovieController {

    private static final Logger LOG = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;


    @PostMapping(path = "/create")
    public @ResponseBody String createMovie(@RequestBody MovieCreateDto mvtd) {
        Movie movie = new Movie();
        movie.setMovieName(mvtd.getMovieName());
        movie.setMovieType(mvtd.getMovieType());
        movie.setMovieRoom(mvtd.getMovieRoom());
        movie.setSeatNumber(mvtd.getSeatNumber());
        movie.setDateMovie(mvtd.getDateMovie());
        movieRepository.save(movie);
        return "Saved";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<MovieInfoDto> getAllMovie() {
        LOG.info("Fetch all the Movies...");
        return movieService.getAllMovie();
    }

    @GetMapping ("movie/{movieId)")
    public MovieInfoDto findById(int movieId) {
        return movieService.findById(movieId);
    }


    @PutMapping("/update/{movieId}")
    public ResponseEntity<Movie> updateMovie(@PathVariable ("movieId") int movieId,
                                             @RequestBody Movie movie) {

        movieRepository.findById(movieId);
        movie.setMovieName(movie.getMovieName());
        movie.setMovieRoom(movie.getMovieRoom());
        movie.setSeatNumber(movie.getSeatNumber());
        movie.setPriceMovie(movie.getPriceMovie());
        movie.setMovieType(movie.getMovieType());

        movieRepository.save(movie);
        movieService.updateMovie(movie);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("movie/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int movieId) {
    movieService.deleteMovie(movieId);
    return ResponseEntity.ok().build();
    }
}
