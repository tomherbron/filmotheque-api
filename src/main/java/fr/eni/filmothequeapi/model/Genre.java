package fr.eni.filmothequeapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "title", length = 255, unique = true)
    String title;

    public Genre(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Genre(String title) {
        this.title = title;
    }

    public Genre() {

    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
