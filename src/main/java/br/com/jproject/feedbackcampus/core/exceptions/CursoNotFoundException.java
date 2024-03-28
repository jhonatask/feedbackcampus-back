package br.com.jproject.feedbackcampus.core.exceptions;

public class CursoNotFoundException extends RuntimeException{

    public CursoNotFoundException(String message){
        super(message);
    }

    public CursoNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public CursoNotFoundException() {

    }
}
