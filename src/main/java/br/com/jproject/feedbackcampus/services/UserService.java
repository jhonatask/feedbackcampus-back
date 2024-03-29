package br.com.jproject.feedbackcampus.services;

import br.com.jproject.feedbackcampus.dto.request.RegisterRequestDTO;
import br.com.jproject.feedbackcampus.entitys.user.User;
import br.com.jproject.feedbackcampus.repositorys.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public User createUser(RegisterRequestDTO body){
        User newUser = new User();
        newUser.setPassword(passwordEncoder.encode(body.password()));
        newUser.setEmail(body.email());
        newUser.setName(body.name());
        userRepository.save(newUser);
        return newUser;
    }
}
