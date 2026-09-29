package devshowcase_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import devshowcase_api.dto.FeedbackRequestDTO;
import devshowcase_api.model.Feedback;
import devshowcase_api.service.FeedbackService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/projects")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/{id}/feedbacks")
    public ResponseEntity<Feedback> createFeedback(
            @PathVariable Long id,
            @Valid @RequestBody FeedbackRequestDTO dto) {

        Feedback feedback = feedbackService.createFeedback(id, dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(feedback);
    }
}