package dev.lucas.exemplos.pessoal;

import dev.lucas.exemplos.pessoal.annotations.MinhaImplementacao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@MinhaImplementacao
public final class BankStatementCSVParser {
    private Path filePath;
    private final String VIRGULA = ",";

    private final List<BankTransaction> transactions = new ArrayList<>();

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public static BankStatementCSVParser newInstance() {
        return new BankStatementCSVParser();
    }

    private BankStatementCSVParser() {
        String root = "src/main/resources/";
        this.filePath = Paths.get(root + "extrato-modelo.csv");

        try {
            List<String> lines = Files.readAllLines(this.filePath);
            this.parse(lines);
        } catch (IOException e) {
            throw new IllegalStateException("Falha na leitura das linhas.");
        }
    }

    public List<BankTransaction> getTransactions() {
        return this.transactions;
    }

    private void parse(List<String> lines) {
        for (String line : lines) {
            final String[] columns = line.split(this.VIRGULA);
            var date = LocalDate.parse(columns[0], this.formatter);
            double amount = Double.parseDouble(columns[1]);
            String description = String.valueOf(columns[2]);
            this.transactions.add(new BankTransaction(date, amount, description));
        }
    }
}
