package br.com.jproject.feedbackcampus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CursoDTO {
    private String id;
    private String nomeCurso;
    private String email;
}
