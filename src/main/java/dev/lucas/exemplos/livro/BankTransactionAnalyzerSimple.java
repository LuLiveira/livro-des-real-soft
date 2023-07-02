package dev.lucas.exemplos.livro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Hello world!
 */
public class BankTransactionAnalyzerSimple {

    private final static String RESOURCES = "src/main/resources/";



    public static void main(String[] args) throws IOException {
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
        final String fileToExtract = args.length == 0 ? "extrato-modelo.csv" : args[0]; //Esse código não faz parte do livro
        final var path = Paths.get(RESOURCES + fileToExtract);

        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(lines);


        calculaTotal(bankTransactions);

        calculaTotalMes(bankTransactions);

    }

    private static void calculaTotalMes(List<BankTransaction> lines) {
        double total = 0d;
        for (final BankTransaction bankTransaction: lines) {
            if (bankTransaction.getDate().getMonth() == Month.JANUARY) {
                final double amount = bankTransaction.getAmount();
                total += amount;
            }
        }

        System.out.println("The total for all transactions in January is " + total);
    }

    private static void calculaTotal(List<BankTransaction> lines) {
        double total = 0d;
        for (final BankTransaction bankTransaction: lines) {
            final double amount = bankTransaction.getAmount();
            total += amount;
        }

        System.out.println("The total for all transactions is " + total);
    }

}
