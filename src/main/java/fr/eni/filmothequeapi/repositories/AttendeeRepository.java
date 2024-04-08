package fr.eni.filmothequeapi.repositories;

import fr.eni.filmothequeapi.model.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {

}
