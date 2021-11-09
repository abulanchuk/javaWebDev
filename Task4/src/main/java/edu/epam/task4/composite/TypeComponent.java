package edu.epam.task4.composite;

public enum TypeComponent {
    TEXT("TEXT"),
    PARAGRAPH("PARAGRAPH"),
    SENTENCE("SENTENCE"),
    LEXEME("LEXEME"),
    WORD("WORD"),
    SYMBOL("SYMBOL");

    private String delimiter;
    TypeComponent(String delimiter){
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
