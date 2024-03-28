package br.com.jproject.feedbackcampus.core.exceptions;

public class FeedbackNotFoundException extends RuntimeException{

    public FeedbackNotFoundException() {
    }

    public FeedbackNotFoundException(String message) {
        super(message);
    }

    public FeedbackNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
