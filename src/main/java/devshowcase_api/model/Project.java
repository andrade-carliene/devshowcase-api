package devshowcase_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String repositoryUrl;
    private Integer upvotes = 0;

private Double averageRating = 0.0;

@ManyToOne
@JoinColumn(name = "profile_id")
private Profile profile;

@OneToMany(mappedBy = "project")
private List<Feedback> feedbacks;

@ManyToMany
@JoinTable(
    name = "project_technology",
    joinColumns = @JoinColumn(name = "project_id"),
    inverseJoinColumns = @JoinColumn(name = "technology_id")
)
private List<Technology> technologies;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getTitle() {
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

public Profile getProfile() {
    return profile;
}

public void setProfile(Profile profile) {
    this.profile = profile;
}

public List<Technology> getTechnologies() {
    return technologies;
}

public void setTechnologies(List<Technology> technologies) {
    this.technologies = technologies;
}

public Integer getUpvotes() {
    return upvotes;
}

public void setUpvotes(Integer upvotes) {
    this.upvotes = upvotes;
}

public Double getAverageRating() {
    return averageRating;
}

public void setAverageRating(Double averageRating) {
    this.averageRating = averageRating;
}

}