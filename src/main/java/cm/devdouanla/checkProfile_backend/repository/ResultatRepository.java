package cm.devdouanla.checkProfile_backend.repository;

import cm.devdouanla.checkProfile_backend.models.Resultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResultatRepository extends JpaRepository<Resultat, UUID> {
    // Custom query methods can be defined here if needed
}
