package br.com.jproject.feedbackcampus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDTO {

    private String id;
    private CursoDTO curso;
    private AlunoDTO aluno;
    private String duvida;
    private String critica;
    private String sugestao;
    private String feedBackPositivo;
}
