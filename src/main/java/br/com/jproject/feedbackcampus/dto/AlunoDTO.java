package br.com.jproject.feedbackcampus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {

    private String id;
    private String nomeAluno;
    private CursoDTO curso;
    private String matricula;
    private String telefone;
}

