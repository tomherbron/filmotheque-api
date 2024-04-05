package fr.eni.filmothequeapi.controllers;

import fr.eni.filmothequeapi.model.Genre;
import fr.eni.filmothequeapi.services.interfaces.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class GenreController {

    GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres")
    public List<Genre> getAllGenres(){
        return genreService.getAllGenres();
    }

    @GetMapping("/genres/{genreId}")
    public Optional<Genre> getGenreById(@PathVariable String genreId){
        return genreService.getGenreById(Long.parseLong(genreId));
    }

}
