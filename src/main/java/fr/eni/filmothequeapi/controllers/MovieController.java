package fr.eni.filmothequeapi.controllers;

import fr.eni.filmothequeapi.model.Movie;
import fr.eni.filmothequeapi.services.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MovieController {

    MovieService movieService;

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
