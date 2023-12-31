package dev.lucas.exemplos.livro.transactions_manager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final int EXPECTED_ATTRIBUTES_LENGTH = 3;

    public BankTransaction parseFrom(final String line) {

        final String[] columns = line.split(",");

        if ( columns.length < EXPECTED_ATTRIBUTES_LENGTH){
            throw new CSVSyntaxException();
        }

        var validator = new OverlySpecificBankStatementValidator(columns[2], columns[0] ,columns[1]);
        var notification = validator.validate();
        if(notification.hasErrors()){
            throw new IllegalStateException(notification.getErrors().toString());
        }

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);

    }

    public List<BankTransaction> parseLinesFrom(final List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (final String line : lines) {
            bankTransactions.add(parseFrom(line));
        }
        return bankTransactions;
    }
}