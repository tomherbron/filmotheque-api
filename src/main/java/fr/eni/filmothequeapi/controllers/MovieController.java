package fr.eni.filmothequeapi.controllers;

import fr.eni.filmothequeapi.model.classes.Movie;
import fr.eni.filmothequeapi.services.interfaces.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Optional<Movie> getMovieById(@PathVariable String movieId){
        return movieService.getMovieById(Long.parseLong(movieId));
    }
}
