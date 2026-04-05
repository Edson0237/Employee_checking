package cm.devdouanla.checkProfile_backend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String enonce;

   @Column(nullable = false)
   private String reponses; // Format: "reponse1;reponse2;reponse3;..."


  

    @Column(nullable = false)
    private int points;

    private String explication;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;


}