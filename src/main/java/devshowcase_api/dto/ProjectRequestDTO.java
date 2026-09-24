package devshowcase_api.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class ProjectRequestDTO {

    @NotBlank(message = "O título do projeto é obrigatório")
    private String title;

    private String description;

    private String repositoryUrl;

private Long profileId;

private List<Long> technologyIds;public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public String getRepositoryUrl() {
    return repositoryUrl;
}

public void setRepositoryUrl(String repositoryUrl) {
    this.repositoryUrl = repositoryUrl;
}

public Long getProfileId() {
    return profileId;
}

public void setProfileId(Long profileId) {
    this.profileId = profileId;
}

public List<Long> getTechnologyIds() {
    return technologyIds;
}

public void setTechnologyIds(List<Long> technologyIds) {
    this.technologyIds = technologyIds;
}

}