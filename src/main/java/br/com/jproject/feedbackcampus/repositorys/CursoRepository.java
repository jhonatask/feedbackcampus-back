package br.com.jproject.feedbackcampus.repositorys;

import br.com.jproject.feedbackcampus.entitys.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends MongoRepository<Curso, String> {
}
