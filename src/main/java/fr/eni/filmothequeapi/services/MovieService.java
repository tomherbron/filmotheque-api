package fr.eni.filmothequeapi.services;

import fr.eni.filmothequeapi.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    public List<Movie> getAllMovies();
    public Optional<Movie> getMovieById(long id);
    public void addMovie();
    public void updateMovie();
    public void deleteMovie();

}
