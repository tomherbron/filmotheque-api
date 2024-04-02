package fr.eni.filmothequeapi.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", length = 255)
    private String title;
    @Column(name = "year")
    private Integer year;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "synopsis", length = 2000)
    private String synopsis;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    @ManyToOne
    @JoinColumn(name = "director_id")
    private Attendee director;
    @ManyToMany
    private List<Attendee> actors = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "rating_id")
    private List<Rating> ratings = new ArrayList<>();

    public Movie() {
    }

    public Movie(long id, String title, Integer year, Integer duration, String synopsis, Genre genre, Attendee director,
                 List<Attendee> actors, List<Rating> ratings) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.ratings = ratings;
    }

    public Movie(String title, Integer year, Integer duration, String synopsis, Genre genre, Attendee director,
                 List<Attendee> actors, List<Rating> ratings) {
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.ratings = ratings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Attendee getDirector() {
        return director;
    }

    public void setDirector(Attendee director) {
        this.director = director;
    }

    public List<Attendee> getActors() {
        return actors;
    }

    public void setActors(List<Attendee> actors) {
        this.actors = actors;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
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
                ", ratings=" + ratings +
                '}';
    }
}
