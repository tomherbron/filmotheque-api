package fr.eni.filmothequeapi.services;

import fr.eni.filmothequeapi.model.Movie;
import fr.eni.filmothequeapi.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImplementation implements MovieService {

    private MovieRepository movieRepository;

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
}
