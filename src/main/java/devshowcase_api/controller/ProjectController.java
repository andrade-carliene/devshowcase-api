package devshowcase_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import devshowcase_api.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

import devshowcase_api.dto.ProjectRequestDTO;
import devshowcase_api.dto.ProjectResponseDTO;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
@PostMapping
public ResponseEntity<ProjectResponseDTO> criar(
        @Valid @RequestBody ProjectRequestDTO dto) {

    ProjectResponseDTO project = projectService.criar(dto);

    return ResponseEntity.status(HttpStatus.CREATED).body(project);
}


@GetMapping
public ResponseEntity<List<ProjectResponseDTO>> listarTodos() {

    List<ProjectResponseDTO> projects = projectService.listarTodos();

    return ResponseEntity.ok(projects);
}

}