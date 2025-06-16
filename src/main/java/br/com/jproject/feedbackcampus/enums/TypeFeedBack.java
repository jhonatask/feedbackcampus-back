package br.com.jproject.feedbackcampus.enums;

public enum TypeFeedBack {

    DUVIDA("DUVIDA"),
    ELOGIO("ELOGIO"),
    CRITICA("CRITICA"),
    DENUNCIA("DENUNCIA"),
    SUGESTAO("SUGESTAO");

    private final String description;

    TypeFeedBack(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
