package devshowcase_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import devshowcase_api.service.TechnologyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

import devshowcase_api.dto.TechnologyRequestDTO;
import devshowcase_api.model.Technology;
@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }
@PostMapping
public ResponseEntity<Technology> criar(
        @Valid @RequestBody TechnologyRequestDTO dto) {

    Technology technology = technologyService.criar(dto);

    return ResponseEntity.status(HttpStatus.CREATED).body(technology);
}

@GetMapping
public ResponseEntity<List<Technology>> listarTodas() {

    List<Technology> technologies = technologyService.listarTodas();

    return ResponseEntity.ok(technologies);
}

}