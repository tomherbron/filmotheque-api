package fr.eni.filmothequeapi.repositories;

import fr.eni.filmothequeapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
