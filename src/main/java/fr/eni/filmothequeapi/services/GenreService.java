package fr.eni.filmothequeapi.services;

import fr.eni.filmothequeapi.model.Genre;
import fr.eni.filmothequeapi.model.Movie;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    public List<Genre> getAllGenres();
    public Optional<Genre> getGenreById(long genreId);
    public void addGenre(Genre genre);
    public void updateGenre(long genreId, Genre genre);
    public void deleteGenreById(long genreId);
}
