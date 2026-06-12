package rs.ac.singidunum.videogamestorebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rs.ac.singidunum.videogamestorebackend.entity.GameTag;

import java.util.Optional;

public interface GameTagRepository extends JpaRepository<GameTag, Integer> {
}
