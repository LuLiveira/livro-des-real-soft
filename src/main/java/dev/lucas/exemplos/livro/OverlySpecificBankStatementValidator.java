package dev.lucas.exemplos.livro;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class OverlySpecificBankStatementValidator {

    private final String description;
    private final String date;
    private final String amount;

    public OverlySpecificBankStatementValidator(String description, String date, String amount) {
        this.description = Objects.requireNonNull(description);
        this.date = Objects.requireNonNull(date);
        this.amount = Objects.requireNonNull(amount);
    }

    public Notification validate() {
        var notification = new Notification();

        if (this.description.length() > 100) {
            notification.addError("The description is too long.");
        }


        try {
            var parsedDate = LocalDate.parse(this.date);
            if (parsedDate.isAfter(LocalDate.now())) {
                notification.addError("date cannot be in the future");
            }
        } catch (DateTimeParseException ex) {
            notification.addError("Invalid format for date");
        }

        try {
            Double.parseDouble(this.amount);
        } catch (NumberFormatException ex) {
            notification.addError("Invalid format for amount");
        }

        return notification;
    }
}
