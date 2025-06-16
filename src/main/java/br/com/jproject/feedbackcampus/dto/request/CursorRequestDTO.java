package br.com.jproject.feedbackcampus.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CursorRequestDTO {
    private String nomeCurso;
    private String email;
}
