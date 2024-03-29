package br.com.jproject.feedbackcampus.controller;

import br.com.jproject.feedbackcampus.dto.request.LoginRequestDTO;
import br.com.jproject.feedbackcampus.dto.request.RegisterRequestDTO;
import br.com.jproject.feedbackcampus.dto.response.ResponseTokenDTO;
import br.com.jproject.feedbackcampus.entitys.user.User;
import br.com.jproject.feedbackcampus.infra.security.TokenService;
import br.com.jproject.feedbackcampus.repositorys.UserRepository;
import br.com.jproject.feedbackcampus.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final UserService userService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        User user = userRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseTokenDTO(token, user.getName()));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        Optional<User> user = userRepository.findByEmail(body.email());
        if(user.isEmpty()) {
            User newUser = userService.createUser(body);
            String token = tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseTokenDTO(newUser.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
