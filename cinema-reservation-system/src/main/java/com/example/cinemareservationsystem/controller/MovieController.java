package com.example.cinemareservationsystem.controller;

import com.example.cinemareservationsystem.Service.implementation.MovieService;
import com.example.cinemareservationsystem.dto.MovieInfoDto;
import com.example.cinemareservationsystem.model.Movie;
import com.example.cinemareservationsystem.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cinema")
public class MovieController {

    private static final Logger LOG = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;


    @PostMapping(path = "/add")
    public @ResponseBody String addNewMovie(@RequestParam String movieName,
                                            String movieType,
                                            Integer movieRoom) {
        Movie movie = new Movie();
        movie.setMovieName(movieName);
        movie.setMovieType(movieType);
        movie.setMovieRoom(movieRoom);
        movieRepository.save(movie);
        return "Saved";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<MovieInfoDto> getAllMovie() {
        LOG.info("Fetch all the Movies...");
        return movieService.getAllMovie();
    }

    @PutMapping("movie")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        movieService.updateMovie(movie);
        return new ResponseEntity<Movie>(movie, HttpStatus.OK);
    }

    @DeleteMapping("article/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
    movieService.deleteMovie(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
