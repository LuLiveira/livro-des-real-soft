package dev.lucas.exemplos.livro;

import java.time.LocalDate;
import java.util.Objects;

public record BankTransaction(LocalDate date, double amount, String description) {

    @Override
    public String toString() {
        return "BankTransaction{"
                + "date=" + date
                + ", amount=" + amount
                + ", description='"
                + description + "'"
                + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(date, that.date) && Objects.equals(description, that.description);
    }
}
