package fr.eni.filmothequeapi.repositories;

import fr.eni.filmothequeapi.model.classes.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {

}
