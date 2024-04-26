package fr.eni.filmothequeapi.model.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "attendees")
@Getter
@Setter
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
