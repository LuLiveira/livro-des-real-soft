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
        var fileToExtract = args.length == 0 ? "extrato-modelo.csv" : args[0]; //Esse código não faz parte do livro
        final var path = Paths.get(RESOURCES + fileToExtract);
        final List<String> lines = Files.readAllLines(path);
        final String mes = "01"; //Janeiro


//        calculaTotal(lines);

        calculaTotalMes(lines);

    }

    private static void calculaTotalMes(List<String> lines) {
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        double total = 0d;
        for (final String line: lines) {
            final String[] columns = line.split(",");
            LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);

            if (date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
        }

        System.out.println("The total for all transactions in January is " + total);
    }

    private static void calculaTotal(List<String> lines) {
        double total = 0d;
        for (final String line: lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transactions is " + total);
    }

}
