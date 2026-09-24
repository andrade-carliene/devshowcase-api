package devshowcase_api.service;

import org.springframework.stereotype.Service;
import devshowcase_api.repository.ProfileRepository;
import devshowcase_api.model.Profile;
import devshowcase_api.dto.ProfileRequestDTO;
@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }
public Profile criar(ProfileRequestDTO dto) {

    Profile profile = new Profile();

    profile.setName(dto.getName());
    profile.setBio(dto.getBio());
    profile.setGithubUrl(dto.getGithubUrl());
    profile.setLinkedinUrl(dto.getLinkedinUrl());

    return profileRepository.save(profile);
}

public Profile buscarPorId(Long id) {
    return profileRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
}

}
