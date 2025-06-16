package br.com.jproject.feedbackcampus.core.emailservice;

public record EmailRequest(String to, String subject, String body) {
}
