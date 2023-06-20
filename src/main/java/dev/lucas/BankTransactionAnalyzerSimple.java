package dev.lucas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.util.Comparator.comparingInt;

/**
 * Hello world!
 */
public class BankTransactionAnalyzerSimple {

    private final static String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        var fileToExtract = args.length == 0 ? "extrato-modelo.csv" : args[0]; //Esse código não faz parte do livro
        final var path = Paths.get(RESOURCES + fileToExtract);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;

        for (final String line: lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transactions is " + total);
    }

}
