package br.com.jproject.feedbackcampus.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "feedbacks")
public class Feedback {
    @Id
    private String id;
    @DBRef
    private Curso curso;
    @DBRef
    private Aluno aluno;
    private String duvida;
    private String critica;
    private String sugestao;
    private String denuncia;
    private String feedBackPositivo;
}
