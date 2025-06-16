package br.com.jproject.feedbackcampus.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CursorResponseDTO {
    private String id;
    private String nomeCurso;
    private String email;
}
