package fr.eni.filmothequeapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

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
    Integer note;

    @Column(name = "comment", length = 500)
    String comment;

    @ManyToOne
    @JoinColumn(name = "user_fk")
    @JsonBackReference
    private User user;

    public Rating(long id, Movie movie, Integer note, String comment, User user) {
        this.id = id;
        this.movie = movie;
        this.note = note;
        this.comment = comment;
        this.user = user;
    }

    public Rating(Movie movie, Integer note, String comment, User user) {
        this.movie = movie;
        this.note = note;
        this.comment = comment;
        this.user = user;
    }

    public Rating() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
