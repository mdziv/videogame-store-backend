package rs.ac.singidunum.videogamestorebackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "game_tag")
public class GameTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_tag_id")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

}
