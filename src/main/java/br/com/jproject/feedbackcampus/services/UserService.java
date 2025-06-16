package br.com.jproject.feedbackcampus.services;

import br.com.jproject.feedbackcampus.core.exceptions.CursoNotFoundException;
import br.com.jproject.feedbackcampus.dto.request.RegisterRequestDTO;
import br.com.jproject.feedbackcampus.entitys.Curso;
import br.com.jproject.feedbackcampus.entitys.user.User;
import br.com.jproject.feedbackcampus.repositorys.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    private final CursoService cursoService;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, CursoService cursoService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.cursoService = cursoService;
    }

    public User createUser(RegisterRequestDTO body){
        Curso curso = cursoService.findCurso(body.cursoId()).orElseThrow(CursoNotFoundException::new);
        User newUser = new User();
        newUser.setPassword(passwordEncoder.encode(body.password()));
        newUser.setEmail(body.email());
        newUser.setName(body.name());
        newUser.setCurso(curso);
        userRepository.save(newUser);
        return newUser;
    }
}
