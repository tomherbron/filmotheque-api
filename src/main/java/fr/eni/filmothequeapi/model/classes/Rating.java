package fr.eni.filmothequeapi.model.classes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "movie_fk")
    @JsonBackReference
    private Movie movie;

    @Column(name = "note")
    int note;

    @Column(name = "comment", length = 500)
    String comment;

    @ManyToOne
    @JoinColumn(name = "user_fk")
    @JsonBackReference
    private User user;

    public Rating(long id, Movie movie, int note, String comment, User user) {
        this.id = id;
        this.movie = movie;
        this.note = note;
        this.comment = comment;
        this.user = user;
    }

    public Rating(Movie movie, int note, String comment, User user) {
        this.movie = movie;
        this.note = note;
        this.comment = comment;
        this.user = user;
    }

    public Rating() {

    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", movie=" + movie +
                ", note=" + note +
                ", comment='" + comment + '\'' +
                ", user=" + user +
                '}';
    }
}
