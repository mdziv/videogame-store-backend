package rs.ac.singidunum.videogamestorebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.videogamestorebackend.entity.Tag;

interface TagRepository extends JpaRepository<Tag, Integer> {
}
