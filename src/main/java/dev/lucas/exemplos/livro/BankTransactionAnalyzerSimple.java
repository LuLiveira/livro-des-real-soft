package dev.lucas.exemplos.livro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;


public class BankTransactionAnalyzerSimple {

    private final static String RESOURCES = "src/main/resources/";

    public void analyze(final String[] args, final BankStatementParser bankStatementParser) throws IOException {
        final String fileToExtract = args == null || args.length == 0 ? "extrato-modelo.csv" : args[0]; //Esse código não faz parte do livro
        final var path = Paths.get(RESOURCES + fileToExtract);

        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final var processor = BankTransactionProcessor.newInstance(bankTransactions);

        collectSummary(processor);
    }

    private void collectSummary(final BankTransactionProcessor processor) {

        System.out.println("The total for all transactions is " + processor.calculateTotalAmount());

        System.out.println("The total for all transactions in January is" + processor.calculateTotalInMonth(Month.JANUARY));

        System.out.println("The total salary received is " + processor.calculateTotalForCategory("Salary"));

        System.out.println("The total amount filter by month and amount is " + processor.findTransactions(new BankTransactionIsInFebruaryAndExpensive()));

        System.out.println("The total amount filter by month and amount is " + processor.findTransactions(
                bankTransaction -> bankTransaction.getDate().getMonth() == Month.FEBRUARY
                        && bankTransaction.getAmount() > 1_000)
        );
    }

}
