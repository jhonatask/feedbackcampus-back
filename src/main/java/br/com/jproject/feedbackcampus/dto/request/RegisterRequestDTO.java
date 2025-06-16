package br.com.jproject.feedbackcampus.dto.request;

public record RegisterRequestDTO(String email, String password, String name, String cursoId) {
}
