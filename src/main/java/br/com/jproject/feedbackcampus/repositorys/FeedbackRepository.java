package br.com.jproject.feedbackcampus.repositorys;

import br.com.jproject.feedbackcampus.entitys.Curso;
import br.com.jproject.feedbackcampus.entitys.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends MongoRepository<Feedback,String> {

    List<Feedback> findByCurso(Curso curso);
}
