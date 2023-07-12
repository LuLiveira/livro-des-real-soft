package dev.lucas.exemplos.livro;

import java.time.Month;
import java.util.List;

/**
 * Hello world!
 */
public class BankTransactionProcessor {

    private final List<BankTransaction> bankTransactionsList;

    private BankTransactionProcessor(List<BankTransaction> bankTransactionsList) {
        this.bankTransactionsList = bankTransactionsList;
    }

    public static BankTransactionProcessor newInstance(List<BankTransaction> bankTransactionsList) {
        if (bankTransactionsList.isEmpty())
            throw new IllegalStateException("Não há dados para calcular.");
        return new BankTransactionProcessor(bankTransactionsList);
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0d;
        for (final BankTransaction bankTransaction: bankTransactionsList) {
            if (bankTransaction.getDate().getMonth() == month) {
                final double amount = bankTransaction.getAmount();
                total += amount;
            }
        }

        //System.out.println("The total for all transactions in January is " + total);
        return total;
    }

    public double calculateTotalAmount() {
        double total = 0d;
        for (final BankTransaction bankTransaction: bankTransactionsList) {
            final double amount = bankTransaction.getAmount();
            total += amount;
        }

        //System.out.println("The total for all transactions is " + total);
        return total;
    }

    public double calculateTotalForCategory(String category) {
        double total = 0d;
        for (final BankTransaction bankTransaction: bankTransactionsList) {
            if (bankTransaction.getDescription().equals(category)) {
                final double amount = bankTransaction.getAmount();
                total += amount;
            }
        }

        //System.out.println("The total for all transactions in January is " + total);
        return total;
    }
}
