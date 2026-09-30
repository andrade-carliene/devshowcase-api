package devshowcase_api.dto;

import java.util.List;

public class ProjectResponseDTO {

    private Long id;
    private String title;
    private String description;
    private String repositoryUrl;
    private Long profileId;
    private List<Long> technologyIds;
    private Double averageRating;
private Integer upvotes;

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

public Double getAverageRating() {
    return averageRating;
}

public void setAverageRating(Double averageRating) {
    this.averageRating = averageRating;
}

public Integer getUpvotes() {
    return upvotes;
}

public void setUpvotes(Integer upvotes) {
    this.upvotes = upvotes;
}

}