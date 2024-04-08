package fr.eni.filmothequeapi.services.implementations;

import fr.eni.filmothequeapi.model.Genre;
import fr.eni.filmothequeapi.model.Movie;
import fr.eni.filmothequeapi.repositories.GenreRepository;
import fr.eni.filmothequeapi.repositories.MovieRepository;
import fr.eni.filmothequeapi.services.interfaces.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    public MovieServiceImpl(MovieRepository movieRepository, GenreRepository genreRepository){
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(long movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    public void addMovie(Movie movie) {

    }

    @Override
    public void updateMovie(long movieId, Movie movie) {

    }

    @Override
    public void deleteMovieById(long movieId) {

    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Optional<Genre> getGenreById(long genreId) {
        return genreRepository.findById(genreId);
    }
}
