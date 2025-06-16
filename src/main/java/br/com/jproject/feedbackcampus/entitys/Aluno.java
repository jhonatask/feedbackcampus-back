package br.com.jproject.feedbackcampus.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "alunos")
public class Aluno {
    @Id
    private String id;
    private String nomeAluno;
    @DBRef
    private Curso curso;
    private String matricula;
    private String telefone;
}
