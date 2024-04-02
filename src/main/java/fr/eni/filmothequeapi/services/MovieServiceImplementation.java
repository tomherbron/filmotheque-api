package fr.eni.filmothequeapi.services;

import fr.eni.filmothequeapi.model.Movie;
import fr.eni.filmothequeapi.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImplementation implements MovieService {

    MovieRepository movieRepository;

    private MovieServiceImplementation(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(long id) {
        return movieRepository.findById(id);
    }

    @Override
    public void addMovie() {

    }

    @Override
    public void updateMovie() {

    }

    @Override
    public void deleteMovie() {

    }
}
