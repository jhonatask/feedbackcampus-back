package br.com.jproject.feedbackcampus.core.emailservice;

import org.springframework.stereotype.Component;

@Component
public interface EmailSender {

    void sendEmail(String to, String subject, String body);
}
