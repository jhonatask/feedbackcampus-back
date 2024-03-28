package br.com.jproject.feedbackcampus.adpters;

import org.springframework.stereotype.Component;

@Component
public interface EmailSenderGateway {
    void sendEmail(String to, String subject, String body);
}
