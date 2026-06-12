package rs.ac.singidunum.videogamestorebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.videogamestorebackend.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
