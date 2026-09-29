package devshowcase_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import devshowcase_api.dto.FeedbackRequestDTO;
import devshowcase_api.model.Feedback;
import devshowcase_api.model.Project;
import devshowcase_api.repository.FeedbackRepository;
import devshowcase_api.repository.ProjectRepository;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final ProjectRepository projectRepository;

    public FeedbackService(
            FeedbackRepository feedbackRepository,
            ProjectRepository projectRepository) {
        this.feedbackRepository = feedbackRepository;
        this.projectRepository = projectRepository;
    }

    public Feedback createFeedback(Long projectId, FeedbackRequestDTO dto) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        Feedback feedback = new Feedback();
        feedback.setComment(dto.getComment());
        feedback.setStars(dto.getStars());
        feedback.setProject(project);

        Feedback savedFeedback = feedbackRepository.save(feedback);

        List<Feedback> feedbacks = feedbackRepository.findAll()
                .stream()
                .filter(f -> f.getProject().getId().equals(projectId))
                .toList();

        double average = feedbacks.stream()
                .mapToInt(Feedback::getStars)
                .average()
                .orElse(0.0);

        project.setAverageRating(average);
        projectRepository.save(project);

        return savedFeedback;
    }
}