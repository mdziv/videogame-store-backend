package rs.ac.singidunum.videogamestorebackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "developer")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "developer_id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

}
