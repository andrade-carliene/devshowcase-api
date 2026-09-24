package devshowcase_api.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devshowcase_api.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

import devshowcase_api.dto.ProfileRequestDTO;
import devshowcase_api.model.Profile;
@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }
@PostMapping
public ResponseEntity<Profile> criar(@Valid @RequestBody ProfileRequestDTO dto) {

    Profile profile = profileService.criar(dto);

    return ResponseEntity.status(HttpStatus.CREATED).body(profile);
}

@GetMapping("/{id}")
public ResponseEntity<Profile> buscarPorId(@PathVariable Long id) {

    Profile profile = profileService.buscarPorId(id);

    return ResponseEntity.ok(profile);
}

}
