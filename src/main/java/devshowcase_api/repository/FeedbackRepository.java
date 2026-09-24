package devshowcase_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import devshowcase_api.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}