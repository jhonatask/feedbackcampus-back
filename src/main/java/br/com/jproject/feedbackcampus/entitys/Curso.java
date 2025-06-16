package br.com.jproject.feedbackcampus.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cursos")
public class Curso {
    @Id
    private String id;
    private String nomeCurso;
    private String email;
}
