package fr.eni.filmothequeapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", length = 255, unique = true)
    private String title;

    @Column(name = "year")
    private Integer year;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "synopsis", length = 2000)
    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "genre_fk")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "director_fk")
    private Attendee director;

    @ManyToMany
    @JoinTable(
            name = "movies_actors",
            joinColumns = @JoinColumn(name = "movie_fk"),
            inverseJoinColumns = @JoinColumn(name = "actor_fk")
    )
    private List<Attendee> actors = new ArrayList<>();

    public Movie() {
    }

    public Movie(long id, String title, Integer year, Integer duration, String synopsis, Genre genre, Attendee director,
                 List<Attendee> actors) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
    }

    public Movie(String title, Integer year, Integer duration, String synopsis, Genre genre, Attendee director,
                 List<Attendee> actors) {
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                ", synopsis='" + synopsis + '\'' +
                ", genre=" + genre +
                ", director=" + director +
                ", actors=" + actors +
                '}';
    }
}
