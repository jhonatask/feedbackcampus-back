package br.com.jproject.feedbackcampus.core.exceptions;

public class EmailServiceExcepetion extends RuntimeException{
    public EmailServiceExcepetion(String message){
        super(message);
    }
    
    public EmailServiceExcepetion(String message, Throwable cause){
        super(message, cause);
    }
}
