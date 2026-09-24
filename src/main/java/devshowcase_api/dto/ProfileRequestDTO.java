package devshowcase_api.dto;

import jakarta.validation.constraints.NotBlank;

public class ProfileRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String name;
    
    private String bio;

private String githubUrl;

private String linkedinUrl;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getBio() {
    return bio;
}

public void setBio(String bio) {
    this.bio = bio;
}

public String getGithubUrl() {
    return githubUrl;
}

public void setGithubUrl(String githubUrl) {
    this.githubUrl = githubUrl;
}

public String getLinkedinUrl() {
    return linkedinUrl;
}

public void setLinkedinUrl(String linkedinUrl) {
    this.linkedinUrl = linkedinUrl;
}

}