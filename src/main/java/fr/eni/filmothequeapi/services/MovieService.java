package fr.eni.filmothequeapi.services;

import fr.eni.filmothequeapi.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();
    Optional<Movie> getMovieById(long id);
    void addMovie();
    void updateMovie();
    void deleteMovie();

}
