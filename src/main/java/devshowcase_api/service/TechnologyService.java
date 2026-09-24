package devshowcase_api.service;

import org.springframework.stereotype.Service;

import devshowcase_api.repository.TechnologyRepository;
import devshowcase_api.model.Technology;
import devshowcase_api.dto.TechnologyRequestDTO;
import java.util.List;
@Service
public class TechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

public Technology criar(TechnologyRequestDTO dto) {

    Technology technology = new Technology();

    technology.setName(dto.getName());

    return technologyRepository.save(technology);
}

public List<Technology> listarTodas() {
    return technologyRepository.findAll();
}

}
