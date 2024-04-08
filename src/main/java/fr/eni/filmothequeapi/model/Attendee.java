package fr.eni.filmothequeapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendees")
public class Attendee extends Person {

    public Attendee() {
    }

    public Attendee(long id, String lastName, String firstName) {
        super(id, lastName, firstName);
    }

    public Attendee(String lastName, String firstName) {
        super(lastName, firstName);
    }


}
