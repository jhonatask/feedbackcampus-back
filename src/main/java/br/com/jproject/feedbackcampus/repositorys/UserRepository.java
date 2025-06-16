package br.com.jproject.feedbackcampus.repositorys;

import br.com.jproject.feedbackcampus.entitys.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
