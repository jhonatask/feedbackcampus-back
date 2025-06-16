package br.com.jproject.feedbackcampus.dto;

import br.com.jproject.feedbackcampus.dto.response.CursorResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {

    private String id;
    private String nomeAluno;
    private CursorResponseDTO curso;
    private String matricula;
    private String telefone;
}

