package dev.lucas.exemplos.livro.transactions_manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Notification {

    private List<String> errors = new ArrayList<>();

    public void addError(final String message) {
        this.errors.add(message);
    }

    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    public String errorsMessage() {
        return this.errors.toString();
    }

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }
}
