package devshowcase_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    private Integer stars;
    @ManyToOne
@JoinColumn(name = "project_id")
@JsonIgnore
private Project project;
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getComment() {
    return comment;
}

public void setComment(String comment) {
    this.comment = comment;
}

public Integer getStars() {
    return stars;
}

public void setStars(Integer stars) {
    this.stars = stars;
}

public Project getProject() {
    return project;
}

public void setProject(Project project) {
    this.project = project;
}

}