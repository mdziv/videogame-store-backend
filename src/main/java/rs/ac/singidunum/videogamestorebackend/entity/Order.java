package rs.ac.singidunum.videogamestorebackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "order_data")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "purchased_at", nullable = false)
    private LocalDateTime purchasedAt;

}
