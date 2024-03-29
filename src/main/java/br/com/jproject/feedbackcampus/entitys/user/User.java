package br.com.jproject.feedbackcampus.entitys.user;


import br.com.jproject.feedbackcampus.entitys.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    private String id;
    private String name;
    @DBRef
    private Curso curso;
    private String password;
    private String email;


}
