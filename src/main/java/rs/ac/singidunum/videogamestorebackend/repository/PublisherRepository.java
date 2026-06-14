package rs.ac.singidunum.videogamestorebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.videogamestorebackend.entity.Publisher;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    Optional<Publisher> findPublisherByName(String name);

}
