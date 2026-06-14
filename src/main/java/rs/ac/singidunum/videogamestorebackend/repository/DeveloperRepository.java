package rs.ac.singidunum.videogamestorebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.videogamestorebackend.entity.Developer;

import java.util.Optional;

public interface DeveloperRepository extends JpaRepository<Developer, Integer> {

    Optional<Developer> findDeveloperByName(String name);

}
