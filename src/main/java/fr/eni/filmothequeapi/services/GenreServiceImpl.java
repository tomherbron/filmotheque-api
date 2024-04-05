package fr.eni.filmothequeapi.services;

import fr.eni.filmothequeapi.model.Genre;
import fr.eni.filmothequeapi.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService{

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getAllGenres() {
        return this.genreRepository.findAll();
    }

    @Override
    public Optional<Genre> getGenreById(long genreId) {
        return genreRepository.findById(genreId);
    }

    @Override
    public void addGenre(Genre genre) {

    }

    @Override
    public void updateGenre(long genreId, Genre genre) {

    }

    @Override
    public void deleteGenreById(long genreId) {

    }
}
