package rs.ac.singidunum.videogamestorebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.videogamestorebackend.entity.Developer;

interface DeveloperRepository extends JpaRepository<Developer, Integer> {
}
