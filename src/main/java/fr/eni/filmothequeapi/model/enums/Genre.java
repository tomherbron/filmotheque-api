package fr.eni.filmothequeapi.model.enums;

import lombok.Getter;

@Getter
public enum Genre {
    ACTION(1, "Action"),
    COMEDY(2, "Comedy"),
    DRAMA(3, "Drama"),
    HORROR(4, "Horror"),
    ROMANCE(5, "Romance"),
    SCIENCE_FICTION(6, "Science Fiction"),
    THRILLER(7, "Thriller"),
    FANTASY(8, "Fantasy");

    private final int id;
    private final String displayName;

    Genre(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public static Genre getById(int id) {
        for (Genre genre : values()) {
            if (genre.getId() == id) {
                return genre;
            }
        }
        throw new IllegalArgumentException("Invalid genre ID: " + id);
    }

}
