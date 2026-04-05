package cm.devdouanla.checkProfile_backend.repository;

import cm.devdouanla.checkProfile_backend.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<Question, UUID> {
    
    // Récupérer toutes les questions liées à un test
    List<Question> findByTestId(UUID testId);
}
