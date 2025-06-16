package br.com.jproject.feedbackcampus.dto;

import br.com.jproject.feedbackcampus.dto.response.CursorResponseDTO;
import br.com.jproject.feedbackcampus.entitys.Aluno;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackDTO {

    private String id;
    private CursorResponseDTO curso;
    private Aluno aluno;
    private String mensagem;
    private String typeFeedback;
}
