package cm.devdouanla.checkProfile_backend.repository;

import cm.devdouanla.checkProfile_backend.models.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface EmployeRepository extends JpaRepository<Employe, UUID> {
    // Additional query methods can be defined here if needed
    // Example: Optional<Employe>  
    // sert à indiquer explicitement que l'employé peut ne pas exister
    //  (et c'est même le cas le plus fréquent quand on cherche par e
    Optional<Employe> findByEmail(String email);
}
