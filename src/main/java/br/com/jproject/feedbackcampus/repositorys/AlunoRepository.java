package br.com.jproject.feedbackcampus.repositorys;

import br.com.jproject.feedbackcampus.entitys.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String > {
}
