package rs.ac.singidunum.videogamestorebackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne(optional = false)
    @JoinColumn(name = "developer_id", nullable = false)
    private Developer developer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @Column(name = "info", nullable = false)
    private String info;

    @Column(name = "release_date", nullable = false)
    private LocalDateTime releaseDate;

    @ManyToMany
    @JoinTable(name = "game_tag",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

}
