package dev.lucas.exemplos.pessoal;

import dev.lucas.exemplos.pessoal.annotations.Entity;

import java.time.LocalDate;

@Entity
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
}
