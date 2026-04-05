package cm.devdouanla.checkProfile_backend.service.interfaces;
import java.util.Optional;
import java.util.UUID;

import cm.devdouanla.checkProfile_backend.dto.PosteDto;
import java.util.List;

public interface PosteService {

    PosteDto create(PosteDto posteDto);

    List<PosteDto> findAll();

    Optional<PosteDto> findById(UUID posteId);

    PosteDto update(UUID posteId, PosteDto posteDto);

    String deleteById(UUID posteId);

    String deleteAll();
}