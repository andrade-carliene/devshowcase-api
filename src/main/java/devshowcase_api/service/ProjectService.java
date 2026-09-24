package devshowcase_api.service;

import org.springframework.stereotype.Service;

import devshowcase_api.repository.ProjectRepository;
import devshowcase_api.model.Project;
import devshowcase_api.model.Profile;
import devshowcase_api.dto.ProjectRequestDTO;
import devshowcase_api.repository.ProfileRepository;
import devshowcase_api.repository.TechnologyRepository;
import java.util.List;
import devshowcase_api.model.Technology;
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
private final ProfileRepository profileRepository;
private final TechnologyRepository technologyRepository;
public ProjectService(
        ProjectRepository projectRepository,
        ProfileRepository profileRepository,
        TechnologyRepository technologyRepository) {

    this.projectRepository = projectRepository;
    this.profileRepository = profileRepository;
    this.technologyRepository = technologyRepository;
}

public Project criar(ProjectRequestDTO dto) {

    Profile profile = profileRepository.findById(dto.getProfileId())
            .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
Project project = new Project();

project.setTitle(dto.getTitle());
project.setDescription(dto.getDescription());
project.setRepositoryUrl(dto.getRepositoryUrl());
project.setProfile(profile);
List<Technology> technologies =
        technologyRepository.findAllById(dto.getTechnologyIds());

project.setTechnologies(technologies);

return projectRepository.save(project);}

public List<Project> listarTodos() {
    return projectRepository.findAll();
}

}