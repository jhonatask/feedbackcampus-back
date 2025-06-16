package br.com.jproject.feedbackcampus.dto.enums;

public enum TypeFeedBack {

    DUVIDA("DUVIDA"),
    DENUNCIA("DENUNCIA"),
    SUGESTAO("SUGESTAO"),
    ELOGIO("ELOGIO"),
    CRITICA("CRITICA");

    private final String description;

    TypeFeedBack(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }


}
