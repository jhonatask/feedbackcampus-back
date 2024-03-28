package br.com.jproject.feedbackcampus.dto.request;

import br.com.jproject.feedbackcampus.dto.AlunoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataFeedBackDTO {
    private String cursoId;
    private AlunoDTO aluno;
    private boolean identificado;
    private String duvida;
    private String critica;
    private String sugestao;
    private String denuncia;
    private String feedBackPositivo;
}
