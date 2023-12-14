package dev.lucas.exemplos.livro.document_manager;

public enum Attributes {

    PATH("path"),
    WIDTH("width"),
    HEIGHT("height"),
    TYPE("type");

    final String value;

    Attributes(String attributeName) {
        this.value = attributeName;
    }
}
