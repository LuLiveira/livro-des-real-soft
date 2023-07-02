package dev.lucas.exemplos.pessoal;

import java.time.LocalDate;

@Entity
public record BankTransactionMinhaImplementacao (LocalDate date, double amount, String description) {

    @Override
    public String toString() {
        return "BankTransaction{"
                + "date=" + date
                + ", amount=" + amount
                + ", description='"
                + description + "'"
                + "'}";
    }
}
