package devshowcase_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.OneToMany;
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

private String name;

private String bio;

private String githubUrl;

private String linkedinUrl;

@OneToMany(mappedBy = "profile")
private List<Project> projects = new ArrayList<>();
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
}public String getBio() {
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
public List<Project> getProjects() {
    return projects;
}

public void setProjects(List<Project> projects) {
    this.projects = projects;
}
}