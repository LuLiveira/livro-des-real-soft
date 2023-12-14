package dev.lucas.exemplos.livro.document_manager;

import java.util.Map;

public class Document {

    private final Map<String, String> attributes;

    Document(final Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttributes(String attributeName) {
        return attributes.get(attributeName);
    }
}
