package br.com.jproject.feedbackcampus.application;

import br.com.jproject.feedbackcampus.adpters.EmailSenderGateway;
import br.com.jproject.feedbackcampus.core.emailservice.EmailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSender {

    private final EmailSenderGateway emailSenderGateway;

    public EmailSenderService(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to,subject,body);
    }
}
