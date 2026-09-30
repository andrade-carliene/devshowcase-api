package devshowcase_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import devshowcase_api.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

import devshowcase_api.dto.ProjectRequestDTO;
import devshowcase_api.dto.ProjectResponseDTO;
import devshowcase_api.model.Project;

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
public ResponseEntity<List<ProjectResponseDTO>> listarTodos(
        @RequestParam(required = false) Long technologyId,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {

    List<ProjectResponseDTO> projects =
            projectService.listarTodos(technologyId, page, size);

    return ResponseEntity.ok(projects);
}


@PutMapping("/{id}/upvote")
public ResponseEntity<Project> upvote(@PathVariable Long id) {
    Project project = projectService.upvote(id);
    return ResponseEntity.ok(project);
}

}