package fr.eni.filmothequeapi.services.interfaces;

import fr.eni.filmothequeapi.model.Genre;
import fr.eni.filmothequeapi.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    public List<Movie> getAllMovies();
    public Optional<Movie> getMovieById(long movieId);
    public void addMovie(Movie movie);
    public void updateMovie(long movieId, Movie movie);
    public void deleteMovieById(long movieId);
    public List<Genre> getAllGenres();
    public Optional<Genre> getGenreById(long genreId);

}
