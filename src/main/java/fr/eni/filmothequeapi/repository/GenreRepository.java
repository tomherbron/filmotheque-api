package fr.eni.filmothequeapi.repository;

import fr.eni.filmothequeapi.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
