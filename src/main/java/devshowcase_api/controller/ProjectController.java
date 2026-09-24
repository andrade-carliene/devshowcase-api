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
import devshowcase_api.model.Project;
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
@PostMapping
public ResponseEntity<Project> criar(
        @Valid @RequestBody ProjectRequestDTO dto) {

    Project project = projectService.criar(dto);

    return ResponseEntity.status(HttpStatus.CREATED).body(project);
}

@GetMapping
public ResponseEntity<List<Project>> listarTodos() {

    List<Project> projects = projectService.listarTodos();

    return ResponseEntity.ok(projects);
}

}