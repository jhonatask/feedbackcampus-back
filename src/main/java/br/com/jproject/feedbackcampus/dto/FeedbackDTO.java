package br.com.jproject.feedbackcampus.dto;

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
    private CursoDTO curso;
    private Aluno aluno;
    private String duvida;
    private String critica;
    private String sugestao;
    private String denuncia;
    private String feedBackPositivo;
}
