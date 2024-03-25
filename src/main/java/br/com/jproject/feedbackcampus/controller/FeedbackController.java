package br.com.jproject.feedbackcampus.controller;


import br.com.jproject.feedbackcampus.dto.FeedbackDTO;
import br.com.jproject.feedbackcampus.dto.request.DataFeedBackDTO;
import br.com.jproject.feedbackcampus.services.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<FeedbackDTO> createFeedBack(@RequestBody DataFeedBackDTO dataFeedBackDTO){
        FeedbackDTO feedback = feedbackService.create(dataFeedBackDTO);
        return ResponseEntity.ok().body(feedback);
    }

    @GetMapping("/{cursoId}")
    public ResponseEntity<List<FeedbackDTO>> findFeedbacksCurso(@PathVariable String cursoId){
       List<FeedbackDTO>  feedbacks = feedbackService.findFeedbackCursoId(cursoId);
       return ResponseEntity.ok().body(feedbacks);

    }
}
