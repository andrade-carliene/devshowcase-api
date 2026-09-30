package devshowcase_api.service;

import org.springframework.stereotype.Service;

import devshowcase_api.repository.ProjectRepository;
import devshowcase_api.model.Project;
import devshowcase_api.model.Profile;
import devshowcase_api.dto.ProjectRequestDTO;
import devshowcase_api.dto.ProjectResponseDTO;
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

public ProjectResponseDTO criar(ProjectRequestDTO dto) {

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

Project salvo = projectRepository.save(project);

ProjectResponseDTO response = new ProjectResponseDTO();
response.setId(salvo.getId());
response.setTitle(salvo.getTitle());
response.setDescription(salvo.getDescription());
response.setRepositoryUrl(salvo.getRepositoryUrl());
response.setProfileId(salvo.getProfile().getId());
response.setTechnologyIds(
    salvo.getTechnologies().stream()
        .map(Technology::getId)
        .toList()
);

return response;
}

public List<ProjectResponseDTO> listarTodos(Long technologyId, int page, int size) {

    List<Project> projects = projectRepository.findAll();

    if (technologyId != null) {
        projects = projects.stream()
                .filter(project -> project.getTechnologies().stream()
                        .anyMatch(technology -> technology.getId().equals(technologyId)))
                .toList();
    }

    int inicio = page * size;
    int fim = Math.min(inicio + size, projects.size());

    if (inicio >= projects.size()) {
        return List.of();
    }

    return projects.subList(inicio, fim).stream()
            .map(project -> {
                ProjectResponseDTO response = new ProjectResponseDTO();
                response.setId(project.getId());
                response.setTitle(project.getTitle());
                response.setDescription(project.getDescription());
                response.setAverageRating(project.getAverageRating());
                response.setUpvotes(project.getUpvotes());
                response.setRepositoryUrl(project.getRepositoryUrl());
                response.setProfileId(project.getProfile().getId());
                response.setTechnologyIds(
                        project.getTechnologies().stream()
                                .map(Technology::getId)
                                .toList()
                );
                return response;
            })
            .toList();
}

public Project upvote(Long id) {
    Project project = projectRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

    project.setUpvotes(project.getUpvotes() + 1);

    return projectRepository.save(project);
}

}