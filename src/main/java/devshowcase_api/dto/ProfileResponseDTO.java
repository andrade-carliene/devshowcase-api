package devshowcase_api.dto;

public class ProfileResponseDTO {

    private Long id;
    private String name;
    private String bio;
    private String githubUrl;
    private String linkedinUrl;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

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