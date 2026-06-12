package rs.ac.singidunum.videogamestorebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.videogamestorebackend.entity.Game;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Integer> {

    Optional<Game> findGameByTitle(String title);

}
