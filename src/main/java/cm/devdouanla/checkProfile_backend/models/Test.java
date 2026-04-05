package cm.devdouanla.checkProfile_backend.models;

import cm.devdouanla.checkProfile_backend.enums.Difficulte;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String titre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulte difficulte;

    @Column(nullable = false)
    private int duree;

    @Column(nullable = false)
    private boolean genereParIA;

    @ManyToOne
    @JoinColumn(name = "competence_id", nullable = false)
    private Competence competence;




}
